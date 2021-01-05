package lipan.top.notes.bio;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author lipan
 */
public class BIOClient {

	private static Charset charset = Charset.forName("UTF-8");

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 8080);
		OutputStream out = s.getOutputStream();

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		String msg = scanner.nextLine();
		// 阻塞，写完成之后才返回
		out.write(msg.getBytes(charset));
		scanner.close();
		s.close();
	}

}
