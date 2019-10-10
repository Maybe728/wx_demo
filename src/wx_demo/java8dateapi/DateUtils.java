package wx_demo.java8dateapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateUtils {

    /**
     * 返回当前的日期
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     * @return
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(判断两个日期是否相等)
     * @Date 10:00 2019/10/10
     * @Param [date1, date2]
     * @return boolean
     **/
    public boolean dateIsEquals(LocalDate date1,LocalDate date2){
        return date1.equals(date2);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(增加时间n个的小时数(纳秒，秒，分，小时))
     * @Date 10:08 2019/10/10
     * @Param [time, hours]
     * @return java.time.LocalTime
     **/
    public LocalTime addHours(LocalTime time,Long n, TemporalUnit unit){
        return time.plus(n,unit);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(在传入日期上增加n个（天，周，月，年，十年，百年，千年）)
     * @Date 10:16 2019/10/10
     * @Param [date, n, unit]
     * @return java.time.LocalDate
     **/
    public LocalDate addDate(LocalDate date,Long n, TemporalUnit unit){
        return date.plus(n,unit);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(判断两个日期的大小（前面日期大：true,相等：false,前面日期小：false）)
     * @Date 10:28 2019/10/10
     * @Param [date1, date2]
     * @return boolean
     **/
    public boolean compareDate(LocalDate date1,LocalDate date2){
        //date1.isBefore(date2)
        return date1.isAfter(date2);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(将日期转化成指定时区的日期)
     * @Date 10:38 2019/10/10
     * @Param [dateTime, strZoneId]
     * @return java.time.ZonedDateTime
     **/
    public ZonedDateTime transformOtherZone(LocalDateTime dateTime,String strZoneId){
        //strZoneId = ZoneId.SHORT_IDS.get("ACT")
        ZoneId zoneId = ZoneId.of(strZoneId);
        ZonedDateTime dateTimeInTokyo = ZonedDateTime.of(dateTime,zoneId);
        return dateTimeInTokyo;
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(判断年份是否是闰年)
     * @Date 10:41 2019/10/10
     * @Param [date]
     * @return boolean
     **/
    public boolean isLeapYear(LocalDate date){
        return date.isLeapYear();
    }

    /**
     * 日期相隔天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static long differDays(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate,endDate);
    }

    /**
     * 日期相隔小时
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    public static long differHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.HOURS.between(startDateTime,endDateTime);
    }

    /**
     * 日期相隔分钟
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    public static long differMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.MINUTES.between(startDateTime,endDateTime);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(日期相隔毫秒数)
     * @Date 11:21 2019/10/10
     * @Param [startDateTime, endDateTime]
     * @return long
     **/
    public static long differMillis(LocalDateTime startDateTime, LocalDateTime endDateTime)  {
        return ChronoUnit.MILLIS.between(startDateTime,endDateTime);
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(判断两个日期之间相差几个月（可以扩展相差多少天，周，年）)
     * @Date 10:45 2019/10/10
     * @Param [date1, date2]
     * @return int
     **/
    public int differMonth(LocalDate date1,LocalDate date2){
        Period period = Period.between(date1,date2);
        return period.getMonths();
    }

    /**
     * @Author HuangShiXing
     * @Description TODO(格式化日期)
     * @Date 11:07 2019/10/10
     * @Param [dateTime, pattern]
     * @return java.lang.String
     **/
    public String formatDate(LocalDateTime dateTime,String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(dateTime);
    }

    public static void main(String[] args) {
        //获取当前日期：2019-10-10
        LocalDate now = LocalDate.now();
        //获取当前时间：10:05:14.592
        LocalTime time = LocalTime.now();
        //2019-10-10T10:05:14.592
        LocalDateTime dateTime = LocalDateTime.now();
        //获取年：2019
        int year = now.getYear();
        //获取月：10
        int month = now.getMonthValue();
        //获取日：10
        int day = now.getDayOfMonth();
        //获取某个特定的日期
        LocalDate birthDay = LocalDate.of(1990,07,28);
        DateUtils dateUtils = new DateUtils();
        System.out.println(DateUtils.differMinutes(LocalDateTime.now().plus(2, ChronoUnit.WEEKS),LocalDateTime.now()));
    }
}

