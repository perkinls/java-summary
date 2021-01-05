package lipan.top.notes.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 解决SimpleDateFormat 线程不安全问题
 * @createTime 2020年12月09日 18:42:00
 */
public class DateTimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS_MS = "yyyy-MM-dd HH:mm:ss.ms";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHH = "yyyyMMddHH";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMM = "yyyyMM";
    public static final String HHMMSS = "HHmmss";
    public static final String HOUR = "mm";
    private static Map<String, ThreadLocal<DateFormat>> FORMAT_CACHE = new ConcurrentHashMap<String, ThreadLocal<DateFormat>>();

    private static ThreadLocal<DateFormat> YYYY_MM_DD_HH_MM_SS_MS_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_MS);
        }
    };

    private static ThreadLocal<DateFormat> YYYY_MM_DD_HH_MM_SS_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        }
    };

    private static ThreadLocal<DateFormat> YYYYMMDDHHMMSS_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYYMMDDHHMMSS);
        }
    };

    private static ThreadLocal<DateFormat> YYYYMMDDHH_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYYMMDDHH);
        }
    };

    private static ThreadLocal<DateFormat> YYYYMMDD_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYYMMDD);
        }
    };

    private static ThreadLocal<DateFormat> YYYYMM_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(YYYYMM);
        }
    };

    private static ThreadLocal<DateFormat> HHMMSS_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(HHMMSS);
        }
    };

    private static ThreadLocal<DateFormat> HOUR_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(HOUR);
        }
    };

    static {
        FORMAT_CACHE.put(YYYY_MM_DD_HH_MM_SS_MS, YYYY_MM_DD_HH_MM_SS_MS_LOCAL);
        FORMAT_CACHE.put(YYYY_MM_DD_HH_MM_SS, YYYY_MM_DD_HH_MM_SS_LOCAL);
        FORMAT_CACHE.put(YYYYMMDDHHMMSS, YYYYMMDDHHMMSS_LOCAL);
        FORMAT_CACHE.put(YYYYMMDDHH, YYYYMMDDHH_LOCAL);
        FORMAT_CACHE.put(YYYYMMDD, YYYYMMDD_LOCAL);
        FORMAT_CACHE.put(YYYYMM, YYYYMM_LOCAL);
        FORMAT_CACHE.put(HHMMSS, HHMMSS_LOCAL);
        FORMAT_CACHE.put(HOUR, HOUR_LOCAL);
    }

    /**
     * 获取DateFormat实例(线程安全)
     *
     * @param pattern
     * @return
     */
    public static DateFormat getDateFormat(String pattern) {

        ThreadLocal<DateFormat> threadLocal = FORMAT_CACHE.get(pattern);
        if (threadLocal == null) {
            threadLocal = new ThreadLocal<DateFormat>();
            DateFormat format = new SimpleDateFormat(pattern);
            threadLocal.set(format);
            FORMAT_CACHE.put(pattern, threadLocal);
        }
        return threadLocal.get();

    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getCurrentDate(String pattern) {

        DateFormat format = getDateFormat(pattern);
        return format.format(new Date());

    }

    /**
     * 获取系统当前时间
     *
     * @param pattern
     * @return
     */
    public static long getCurrentDateLong(String pattern) {

        return Long.parseLong(getCurrentDate(pattern));

    }

    /**
     * 获取系统当前时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @return
     */
    public static String getCurrentDate() {

        return getCurrentDate(YYYYMMDDHHMMSS);

    }

    /**
     * 获取系统当前时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @return
     */
    public static long getCurrentDateLong() {

        return getCurrentDateLong(YYYYMMDDHHMMSS);

    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定时间的日期（指定分钟和秒）
     *
     * @param minute
     * @param second
     * @param pattern
     * @return
     */
    public static String getDay(int minute, int second, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定时间的日期（指定分钟和秒）
     *
     * @param minute
     * @param second
     * @param pattern
     * @return
     */
    public static long getDayLong(int minute, int second, String pattern) {

        return Long.parseLong(getDay(minute, second, pattern));

    }

    /**
     * 获取指定时间的日期（指定分钟和秒，默认格式：YYYYMMDDHHMMSS）
     *
     * @param minute
     * @param second
     * @return
     */
    public static String getDay(int minute, int second) {

        return getDay(minute, second, YYYYMMDDHHMMSS);

    }

    /**
     * 获取指定时间的日期（指定分钟和秒，默认格式：YYYYMMDDHHMMSS）
     *
     * @param minute
     * @param second
     * @return
     */
    public static long getDayLong(int minute, int second) {

        return getDayLong(minute, second, YYYYMMDDHHMMSS);

    }


    /**
     * 获取指定毫秒之后的时间
     *
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static String getNextDate(long miliseconds, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTime().getTime() + miliseconds);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定毫秒之后的时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @param miliseconds
     * @return
     */
    public static long getNextDateLong(long miliseconds) {

        return Long.parseLong(getNextDate(miliseconds, YYYYMMDDHHMMSS));

    }

    /**
     * 获取指定毫秒之后的时间
     *
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static long getNextDateLong(long miliseconds, String pattern) {

        return Long.parseLong(getNextDate(miliseconds, pattern));

    }


    /**
     * 获取指定毫秒之后的时间
     *
     * @param date
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static String getNextDate(Date date, long miliseconds, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() + miliseconds);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }


    /**
     * 获取指定毫秒之后的时间
     *
     * @param date
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static long getNextDateLong(Date date, long miliseconds, String pattern) {

        return Long.parseLong(getNextDate(date, miliseconds, pattern));

    }


    /**
     * 获取指定毫秒之后的时间
     *
     * @param date
     * @param miliseconds
     * @return
     */
    public static String getNextDate(Date date, long miliseconds) {

        return getNextDate(date, miliseconds, YYYYMMDDHHMMSS);

    }


    /**
     * 获取指定毫秒之后的时间
     *
     * @param date
     * @param miliseconds
     * @return
     */
    public static long getNextDateLong(Date date, long miliseconds) {

        return Long.parseLong(getNextDate(date, miliseconds));

    }


    /**
     * 获取指定毫秒之前的时间
     *
     * @param date
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static String getPreDate(Date date, long miliseconds, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() - miliseconds);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定毫秒之前的时间
     *
     * @param miliseconds
     * @return
     */
    public static long getPreDateLong(Date date, long miliseconds, String pattern) {

        return Long.parseLong(getPreDate(date, miliseconds, pattern));

    }

    /**
     * 获取指定毫秒之前的时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @param miliseconds
     * @return
     */
    public static String getPreDate(Date date, long miliseconds) {

        return getPreDate(date, miliseconds, YYYYMMDDHHMMSS);

    }


    /**
     * 获取指定毫秒之前的时间
     *
     * @param date
     * @param miliseconds
     * @return
     */
    public static long getPreDateLong(Date date, long miliseconds) {

        return Long.parseLong(getPreDate(date, miliseconds));

    }

    /**
     * 获取指定毫秒之前的时间
     *
     * @param createTime
     * @param miliseconds
     * @return
     * @throws ParseException
     */
    public static Long getPreDateLong(Long createTime, long miliseconds) throws ParseException {

        Date logDate = parse(createTime + "", YYYYMMDDHHMMSS);
        return Long.parseLong(getPreDate(logDate, miliseconds));

    }

    /**
     * 获取指定时间开始几天内的时间（默认格式：YYYYMMDD000000）
     *
     * @param createTime 操作时间
     * @param day        指定多少天前
     * @return
     * @throws ParseException
     */
    public static Long getFewDaysAgoStart(Long createTime, int day) throws ParseException {

        return Long.parseLong(getFewDaysAgoDay(createTime, day) + "000000");

    }

    /**
     * 获取指定时间开始几天内的时间（默认格式：YYYYMMDD235959）
     *
     * @param createTime 操作时间
     * @param day        指定多少天前
     * @return
     * @throws ParseException
     */
    public static Long getFewDaysAgoEnd(Long createTime, int day) throws ParseException {

        return Long.parseLong(getFewDaysAgoDay(createTime, day) + "235959");

    }

    /**
     * 获取指定时间开始几天内的日期（默认格式：YYYYMMDD）
     *
     * @param createTime 操作时间
     * @param day        指定多少天前
     * @return
     * @throws ParseException
     */
    public static long getFewDaysAgoDay(Long createTime, int day) throws ParseException {

        return Long.parseLong(getPreDay(createTime, day - 1));

    }

    /**
     * 获取指定天之前的日期（默认格式：YYYYMMDD）
     *
     * @param createTime 操作时间
     * @param day        指定前多少天
     * @return
     * @throws ParseException
     */
    public static String getPreDay(Long createTime, int day) throws ParseException {

        return getPreDay(createTime, day, YYYYMMDD);

    }

    /**
     * 获取指定天之前的日期（默认格式：YYYYMMDD）
     *
     * @param createTime 操作时间
     * @param day        指定前多少天
     * @return
     * @throws ParseException
     */
    public static long getPreDayStart(Long createTime, int day) throws ParseException {

        return Long.parseLong(getPreDay(createTime, day, YYYYMMDD) + "000000");

    }

    /**
     * 获取指定天之前的结束日期（默认格式：YYYYMMDDHHMMSS）
     *
     * @param createTime 操作时间
     * @param day        指定前多少天
     * @return
     * @throws ParseException
     */
    public static long getPreDayEnd(Long createTime, int day) throws ParseException {

        return Long.parseLong(getPreDay(createTime, day, YYYYMMDD) + "235959");

    }

    /**
     * 获取指定天之前的日期
     *
     * @param createTime 操作时间
     * @param day        指定前多少天
     * @param pattern    日期格式
     * @return
     * @throws ParseException
     */
    public static String getPreDay(Long createTime, int day, String pattern) throws ParseException {

        Date date = parse(createTime + "", YYYYMMDDHHMMSS);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - day);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定天之前的时间（默认格式：YYYYMMDD）
     *
     * @param day
     * @return
     */
    public static String getPreDay(int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - day);

        DateFormat format = getDateFormat(YYYYMMDD);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定天之前的时间
     *
     * @param day
     * @param pattern
     * @return
     */
    public static String getPreDay(int day, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - day);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定天之前的时间
     *
     * @param date
     * @param day
     * @param pattern
     * @return
     */
    public static String getPreDay(Date date, int day, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - day);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定月之前的时间
     *
     * @param month
     * @return
     */
    public static String getPreMonth(int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - month);

        DateFormat format = getDateFormat(YYYYMMDD);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定月之前的时间
     *
     * @param month
     * @param pattern
     * @return
     */
    public static String getPreMonth(int month, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - month);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定月之前的时间
     *
     * @param month
     * @param pattern
     * @return
     */
    public static long getPreMonthLong(int month, String pattern) {

        return Long.parseLong(getPreMonth(month, pattern));

    }

    /**
     * 获取指定天之后的时间
     *
     * @param day
     * @param pattern
     * @return
     */
    public static String getNextDay(int day, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + day);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }

    /**
     * 获取指定天之后的时间（默认格式：YYYYMMDD）
     *
     * @param day
     * @return
     */
    public static String getNextDay(int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + day);

        DateFormat format = getDateFormat(YYYYMMDD);
        return format.format(cal.getTime());

    }


    /**
     * 获取指定毫秒之前的时间
     *
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static String getPreDate(long miliseconds, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTime().getTime() - miliseconds);

        DateFormat format = getDateFormat(pattern);
        return format.format(cal.getTime());

    }


    /**
     * 获取指定毫秒之前的时间戳
     *
     * @param miliseconds
     * @return
     */
    public static long getPreDateTimestamp(long miliseconds) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(cal.getTime().getTime() - miliseconds);

        return cal.getTime().getTime();

    }

    /**
     * 获取指定毫秒之前的时间并返回指定类型值
     *
     * @param miliseconds
     * @param pattern
     * @return
     */
    public static long getPreDateLong(long miliseconds, String pattern) {

        return Long.parseLong(getPreDate(miliseconds, pattern));

    }


    /**
     * 获取指定毫秒之前的时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @param miliseconds
     * @return
     */
    public static String getPreDate(long miliseconds) {

        return getPreDate(miliseconds, YYYYMMDDHHMMSS);

    }

    /**
     * 获取指定毫秒之前的时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @param miliseconds
     * @return
     */
    public static long getPreDateLong(long miliseconds) {

        return getPreDateLong(miliseconds, YYYYMMDDHHMMSS);

    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {

        return getDateFormat(pattern).format(date);

    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static long formatToLong(Date date, String pattern) {

        return Long.parseLong(format(date, pattern));

    }

    /**
     * 格式化日期
     *
     * @param source
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parse(String source, String pattern) throws ParseException {

        return getDateFormat(pattern).parse(source);

    }

    /**
     * 判断一个时间是否在一个时间段内
     *
     * @param date
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static boolean isInDate(Date date, Date startDate, Date endDate) throws ParseException {

        return date.getTime() >= startDate.getTime() && date.getTime() <= endDate.getTime();

    }

    /**
     * 获取当天的起始时间
     *
     * @return 时间戳
     */
    public static long getCurrentDayStartTime() {

        return getCurrentDayTime(0, 0, 0, 0);

    }

    /**
     * 获取当天的结束时间
     *
     * @return 时间戳
     */
    public static long getCurrentDayEndTime() {

        return getCurrentDayTime(23, 59, 59, 999);

    }

    /**
     * 获取当天的时间
     *
     * @param hour
     * @param minute
     * @param second
     * @param millisecond
     * @return
     */
    public static long getCurrentDayTime(int hour, int minute, int second, int millisecond) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);

        return calendar.getTime().getTime();

    }

    /**
     * 获取当天的时间
     *
     * @return
     */
    public static String getCurrentDayTime(int hour, int minute, int second, int millisecond, String pattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);

        return format(calendar.getTime(), pattern);

    }

    /**
     * 获取指定时间10分钟之后的时间
     *
     * @param createTime 记录创建的时间
     * @return
     * @throws ParseException
     */
    public static Long getNextTimeDate(long createTime) throws ParseException {

        Date logDate = parse(createTime + "", YYYYMMDDHHMMSS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(logDate);
        cal.setTimeInMillis(cal.getTime().getTime() + 600000);

        DateFormat format = getDateFormat(YYYYMMDDHHMMSS);
        String endTime = format.format(cal.getTime());
        return Long.parseLong(endTime);

    }

    /**
     * 获取指定时间之后指定的天（默认格式：YYYYMMDD）
     *
     * @param createTime 指定的时间点
     * @param day        指定后多少天
     * @return
     * @throws ParseException
     */
    public static Long getNextDay(Long createTime, int day) throws ParseException {

        Date logDate = parse(createTime + "", YYYYMMDDHHMMSS);
        Long startTime = getNextDateLong(logDate, day * 60 * 1000 * 1440L, YYYYMMDD); // 获取N天前的天
        return startTime;

    }

    /**
     * 获取指定时间之后指定天的时间（默认格式：YYYYMMDDHHMMSS）
     *
     * @param createTime 指定的时间点
     * @param day        指定后多少天
     * @return
     * @throws ParseException
     */
    public static Long getNextDayDate(Long createTime, int day) throws ParseException {

        Date logDate = parse(createTime + "", YYYYMMDDHHMMSS);
        Long startTime = getNextDateLong(logDate, day * 60 * 1000 * 1440L); // 获取N天前的时间
        return startTime;

    }

    /**
     * 获取当前对应的毫秒
     *
     * @param createTime
     * @return
     * @throws ParseException
     */
    public static Long getTimeMillis(Long createTime) throws ParseException {

        Date logDate = parse(createTime + "", YYYYMMDDHHMMSS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(logDate);
        return cal.getTimeInMillis();

    }

    /**
     * 将日期转为时间戳
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static String dateToTimestamp(String date, String pattern) throws ParseException {

        return String.valueOf(parse(date, pattern).getTime());

    }

    /**
     * 根据出生年月日获取年龄
     *
     * @param birthDay
     * @return
     * @throws ParseException
     */
    public static int getAge(long birthDay) throws ParseException {
        Date birthDate = parse(birthDay + "", YYYYMMDD);
        Calendar cal = Calendar.getInstance();
        if (cal.getTime().before(birthDate)) {
            throw new IllegalArgumentException("The now is before birthDay.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDate);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }

            } else {
                age--;
            }
        }
        return age;

    }

    /**
     * 指定天之后的时间 specifiedDay:指定天(2018-11-10 12:12:12) day:指定的天数
     */

    public static Long getSpecifiedDayAfter(String specifiedDay, int day) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int OtherDay = c.get(Calendar.DATE);
        c.set(Calendar.DATE, OtherDay + day);

        String dayAfter = new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
        return Long.parseLong(dayAfter);

    }

    /**
     * 获取指定小时之前的时间（默认格式：yyyyMMddHHmmss）
     *
     * @param createTime 操作时间
     * @param hour       指定多少小时前
     * @return yyyyMMddHHmmss
     * @throws ParseException
     */
    public static Long getFewHourAgoStart(Long createTime, int hour) throws ParseException {
        Date date = parse(createTime + "", YYYYMMDDHHMMSS);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hour);

        DateFormat format = getDateFormat("yyyyMMddHHmmss");

        return Long.parseLong(format.format(cal.getTime()));
    }


    /**
     * 获取指定多少月之前的时间（默认格式：yyyyMMddHHmmss）
     *
     * @param createTime 操作时间
     * @param month      指定多少月前
     * @return yyyyMMddHHmmss
     * @throws ParseException
     */
    public static Long getFewMonthAgoStart(Long createTime, int month) throws ParseException {
        Date date = parse(createTime + "", YYYYMMDDHHMMSS);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - month);

        DateFormat format = getDateFormat("yyyyMMddHHmmss");

        return Long.parseLong(format.format(cal.getTime()));
    }

}
