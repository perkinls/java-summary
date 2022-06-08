package lipan.top.notes.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description thenApply()多次链式转化并返回最终的加工结果, 类似于scala和spark的map算子
 * @createTime 2020年12月21日 21:17:00
 */
public class CompletableFutureDemoV4 {
    /**
     * thenApply()多次链式转化并返回最终的加工结果, 类似于scala和spark的map算子
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void asyncThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程" + Thread.currentThread().getName() + " supplyAsync");
            return "123";
        });
        CompletableFuture<Integer> result1 = task.thenApply(number -> {
            System.out.println("线程" + Thread.currentThread().getName() + " thenApply1 ");
            return Integer.parseInt(number);
        });
        CompletableFuture<Integer> result2 = result1.thenApply(number -> {
            System.out.println("线程" + Thread.currentThread().getName() + " thenApply2 ");
            return number * 2;
        });
        System.out.println("线程" + Thread.currentThread().getName() + " => " + result2.get());
    }

    /**
     * thenAccept()可以接受Future的一个返回值，但是本身不在返回任何值，适合用于多个callback函数的最后一步操作使用。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void asyncThenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " supplyAsync");
            return "123";
        });
        CompletableFuture<Integer> chain1 = task.thenApply(number -> {
            System.out.println(Thread.currentThread().getName() + " thenApply1");
            return Integer.parseInt(number);
        });
        CompletableFuture<Integer> chain2 = chain1.thenApply(number -> {
            System.out.println(Thread.currentThread().getName() + " thenApply2");
            return number * 2;
        });
        CompletableFuture<Void> result = chain2.thenAccept(product -> {
            System.out.println(Thread.currentThread().getName() + " thenAccept=" + product);
        });
        System.out.println("---" + result.get() + "---");
        System.out.println(Thread.currentThread().getName() + " end");
    }

    /**
     * thenRun(),一般也用于回调函数最后的执行,但这个方法不接受回调函数的返回值,纯粹就代表执行任务的最后一个步骤
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void asyncThenRun() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "thenRun: 开始");
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync: 一阶段任务");
            return null;
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName() + "thenRun: 收尾任务");
        }).get();
    }

    /**
     * thenCompose()：合并两个有依赖关系的CompletableFutures的执行结果
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void asyncThenCompose() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "1");
        CompletableFuture<String> nestedResult =
                future1.thenCompose(value -> CompletableFuture.supplyAsync(() -> value + "2"));
        System.out.println(nestedResult.get());
    }


    /**
     * anyOf:多个任务结果合并
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void multiTaskCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "wait 4 seconds";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "wait 2 seconds";
        });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "wait 10 seconds";
        });
        CompletableFuture<Object> result = CompletableFuture.anyOf(f1, f2, f3);
        System.out.println(result.get());
    }

    /**
     * exceptionally异常处理
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void exceptionProcessV1() throws ExecutionException, InterruptedException {
        int age = -1;
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("性别必须大于0");
            }
            if (age < 18) {
                return "未成年人";
            }
            return "成年人";
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return "发生 异常" + ex.getMessage();
        });
        System.out.println(task.get());
    }

    /**
     * 异常处理;(如果正常执行，也会执行handle方法)
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void exceptionProcessV2() throws ExecutionException, InterruptedException {
        int age = -10;
        CompletableFuture<String> task = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                if (age < 0) {
                    throw new IllegalArgumentException("性别必须大于0");
                }
                if (age < 18) {
                    return "未成年人";
                }
                return "成年人";
            }
        }).handle((res, ex) -> {
            System.out.println("执行handle");
            if (ex != null) {
                System.out.println("发生异常");
                return "发生 异常" + ex.getMessage();
            }
            return res;
        });
        System.out.println(task.get());
    }

    public static void main(String[] args) throws Exception {
//        asyncThenApply();
//        asyncThenAccept();
//        asyncThenRun();
//        asyncThenCompose();
//        multiTaskCompose();
        exceptionProcessV1();
        exceptionProcessV2();
    }
}
