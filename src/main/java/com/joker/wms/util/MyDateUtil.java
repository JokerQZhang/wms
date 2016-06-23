package com.joker.wms.util;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyDateUtil {
	private static SimpleDateFormat sdf;
	private static StringBuffer sb;
	private static Calendar c;
	/**
	 * 通过传入一个毫秒类型的字符串,返回该毫秒对应的时间,如果为null范围当前时间向前推延30天的时间. 格式如:200801.
	 * 
	 * @param selectedTime
	 * @return yyyyMM类型的日期
	 */
	public static String getCurPartTime(String selectedTime) {
		Date selectedDate = null;
		if (selectedTime != null && selectedTime.length() > 0) {
			selectedDate = new Date(Long.parseLong(selectedTime));
		} else {
			selectedDate = new Date();
			long myTime = (selectedDate.getTime() / 1000) - 60 * 60 * 24 * 30;
			selectedDate.setTime(myTime * 1000);
		}
		sdf = new SimpleDateFormat("yyyyMM");
		String curDate = sdf.format(selectedDate);
		return curDate;
	}

	/**
	 * 返回数组,0:为年;1:为月;2:为天. 用于查询数据库,默认的到当前月
	 * 
	 * @param yearmonMiliseconds
	 * @return
	 */
	public static Integer[] getYearMon(String yearmonMiliseconds) {
		Integer[] yearMon = new Integer[3];
		Date selectedDate = null;
		if (yearmonMiliseconds != null
				&& yearmonMiliseconds.trim().length() > 0) {
			selectedDate = new Date(Long.parseLong(yearmonMiliseconds));
		} else {
			selectedDate = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(selectedDate);
		yearMon[0] = c.get(Calendar.YEAR);
		yearMon[1] = c.get(Calendar.MONTH) + 1;
		yearMon[2] = c.get(Calendar.DATE);
		return yearMon;
	}

	/**
	 * 取得标准时间
	 * 
	 * @return 标准sql时间
	 */
	public static String getCritriaSqlTime(String pattner) {
		if (pattner == null) {
			pattner = "yyyy-MM-dd kk:mm";
		}
		sdf = new SimpleDateFormat(pattner);
		return sdf.format(new Date());
	}

	/**
	 * 传入要向前推进的年的数字，比如当前是2008年，beforeYearNums=8,那么返回2000年
	 * 
	 * @param beforeYearNums
	 * @return
	 */
	public static Integer beforeCurYear(Integer beforeYearNums) {
		if (beforeYearNums == null || beforeYearNums < 0)
			beforeYearNums = 0;
		Date d = new Date();
		long aimT = d.getTime() / 1000 - 60 * 60 * 24 * 365 * beforeYearNums;
		d.setTime(aimT * 1000);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 返回该月的最后一天
	 * 
	 * @param month
	 *            当前月
	 * @return
	 */
	public static Integer getMonthLastDay(Integer year, Integer month) {
		Integer lastDay = 31;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			break;
		case 2:
			if (year % 4 == 0)
				lastDay = 29;
			else
				lastDay = 28;
			break;
		default:
			lastDay = 30;
		}
		return lastDay;
	}

	/**
	 * 返回该年，月的时间范围，例如：2008年2月份的返回：2.1~~2.29
	 * 
	 * @param year
	 * @param month
	 * @param conFlag
	 *            连接符号
	 * @return
	 */
	public static String getMonthRangeDay(Integer year, Integer month,
			String conFlag) {
		if (conFlag == null)
			conFlag = "~~";
		sb = new StringBuffer();
		sb.append(month);
		sb.append(".");
		sb.append(1);
		sb.append(conFlag);
		sb.append(month);
		sb.append(".");
		sb.append(MyDateUtil.getMonthLastDay(year, month));
		return sb.toString();
	}

	/**
	 * 传入一周开始的星期，默认为周一为一周开始的时间.<br>
	 * year 2008.<br>
	 * day 1~31.<br>
	 * 例如：(Calendar.SUNDAY,2008,1,1)表示2008年第一天在这2008年中是第几周
	 * 
	 * @param FirstDay
	 *            Calendar.SUNDAY Calendar.MONDAY
	 * @param year
	 * @param month
	 *            0~11 表示 1~12
	 * @return 该天在全年中是第几周
	 */
	public static Integer getWeekOfYear(Integer FirstDay, Integer year,
			Integer month, Integer day) {
		if (FirstDay == null)
			FirstDay = Calendar.MONDAY;
		Calendar d = Calendar.getInstance();
		d.setFirstDayOfWeek(FirstDay);
		d.set(year, month - 1, day);
		int weeknum = d.get(Calendar.WEEK_OF_YEAR);
		if (month == 12 && weeknum == 1)
			weeknum = 53;
		return weeknum;
	}

	/**
	 * 拿到某一年的某一周的时间范围
	 * 
	 * @param year
	 *            年
	 * @param week
	 *            周
	 * @param conflag
	 *            时间连接符号
	 * @return 该年，该周的时间范围
	 * @throws Exception
	 */
//	public static String getWeekRange(Integer year, Integer week, String conflag)
//			throws Exception {
//		if (conflag == null)
//			conflag = "~~";
//		DBStatement dbs = new DBStatement();
//		try {
//			dbs
//					.setSql("select min(t.datestring) as min,max(t.datestring) as max from zx_dm_datemanage t where t.useyear=:year and t.weeknum=:week");
//			dbs.parameters().setInt("year", year);
//			dbs.parameters().setInt("week", week);
//			VariantSet v = dbs.query();
//			StringBuffer sb = new StringBuffer();
//			sb.append(v.getString("min").substring(0, 10));
//			sb.append(conflag);
//			sb.append(v.getString("max").substring(0, 10));
//		} finally {
//			dbs.close();
//			dbs = null;
//		}
//		return sb.toString();
//	};

	/**
	 * 拿到下个月
	 * 
	 * @param month
	 * @return
	 */
	public static Integer getNextMonth(Integer month) {
		if (month == 12) {
			return 1;
		} else {
			return month + 1;
		}
	};

	/**
	 * 前一个月
	 * 
	 * @param month
	 * @return
	 */
	public static Integer getPreMonth(Integer month) {
		if (month == 1)
			return 12;
		else
			return month - 1;
	};

	/**
	 * 拿到req对象得到的一个date类型的字符串，将其解析为年月日
	 * 
	 * @param milisecs
	 * @return
	 */
	public static Integer[] getReqMillOfFormat(String milisecs) {
		c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(milisecs));
		Integer[] ym = new Integer[3];
		ym[0] = c.get(Calendar.YEAR);
		ym[1] = c.get(Calendar.MONTH) + 1;
		ym[2] = c.get(Calendar.DATE);
		return ym;
	};

	/**
	 * 拿到req对象得到的一个date类型的字符串，将其解析为年月日
	 * 
	 * @param milisecs
	 * @return
	 */
	public static Integer[] getReqMillOfFormat(Long milisecs) {
		c = Calendar.getInstance();
		c.setTimeInMillis(milisecs);
		Integer[] ym = new Integer[3];
		ym[0] = c.get(Calendar.YEAR);
		ym[1] = c.get(Calendar.MONTH) + 1;
		ym[2] = c.get(Calendar.DATE);
		return ym;
	};

	/**
	 * 格式化一个日期字符串
	 * 
	 * @param formate
	 *            yyyy~MM~dd 默认为yyyy-MM-dd
	 * @param year
	 *            2008
	 * @param month
	 *            7
	 * @param day
	 *            15
	 * @return 2008-7-15
	 */
	public static String getFormatedString(String formate, Integer[] ym) {
		if (formate == null) {
			formate = "yyyy-MM-dd";
		}
		sdf = new SimpleDateFormat(formate);
		c = Calendar.getInstance();
		c.set(ym[0], ym[1] - 1, ym[2]);
		return sdf.format(c.getTimeInMillis());
	};

	/**
	 * 格式化一个日期字符串
	 * 
	 * @param formate
	 *            yyyy~MM~dd 默认为yyyy-MM-dd
	 * @param year
	 *            2008
	 * @param month
	 *            7
	 * @param day
	 *            15
	 * @return 2008-7-15
	 */
	public static String getFormatedString(String formate, Integer year,
			Integer month, Integer day) {
		if (formate == null) {
			formate = "yyyy-MM-dd";
		}
		sdf = new SimpleDateFormat(formate);
		c = Calendar.getInstance();
		c.set(year, month - 1, day);
		return sdf.format(c.getTimeInMillis());
	};

	/**
	 * 格式化一个日期字符串.
	 * 
	 * @param formate
	 * @param date
	 * @return
	 */
	public static String getFormatedString(String formate, Date date) {
		if (formate == null) {
			formate = "yyyy-MM-dd";
		}
		if(date == null){
			return "";
		}
		sdf = new SimpleDateFormat(formate);
		c = Calendar.getInstance();
		c.setTime(date);
		return sdf.format(c.getTimeInMillis());
	}

	/**
	 * 拿到一个Oracle的to_date字符串.
	 * 
	 * @param formate
	 *            默认格式yyyy-MM-dd
	 * @param dayStr
	 *            2008-7-15
	 * @return to_date('2008-7-15','yyyy-MM-dd')
	 */
	public static String getOracleDateStr(String formate, String dayStr) {
		sb = new StringBuffer();
		String realStr = null;
		if (formate == null)
			formate = "yyyy-MM-dd";
		sb.append("to_date('");
		try {
			realStr = dayStr.substring(0, 10);
		} catch (RuntimeException e) {
			realStr = dayStr.substring(0, 9);
		}
		sb.append(realStr);
		sb.append("','");
		sb.append(formate);
		sb.append("')");
		return sb.toString();
	}

	/**
	 * 拿到一个Oracle的to_date字符串.
	 * 
	 * @param formate
	 *            默认格式yyyy-MM-dd
	 * @param dayStr
	 *            2008-7-15
	 * @return to_date('2008-7-15','yyyy-MM-dd')
	 */
	public static String getOracleDateStr(String formate, Date date) {
		sb = new StringBuffer();
		if (formate == null)
			formate = "yyyy-MM-dd";
		sb.append("to_date('");
		sb.append(getFormatedString(null, date));
		sb.append("','");
		sb.append(formate);
		sb.append("')");
		return sb.toString();
	}

	public static Date getDateFromStr(String str) throws Exception {
		StringTokenizer st = new StringTokenizer(str.trim(), "-");
		int i = 0;
		Integer useyear = null;
		Integer usemonth = null;
		Integer date = null;
		while (st.hasMoreTokens()) {
			switch (i) {
			case 0:
				useyear = Integer.parseInt(st.nextToken());
				break;
			case 1:
				usemonth = Integer.parseInt(st.nextToken());
				break;
			case 2:
				date = Integer.parseInt(st.nextToken());
				break;
			default:
				throw new Exception("不是一个正确的日期字符串,必须为yyyy-MM-dd形式");
			}
			i++;
		}
		Date d = new Date(useyear - 1900, usemonth - 1, date);
		return d;
	}

	public static Date getDateFromStr(String formate, String date)
			throws Exception {
		if (formate == null) {
			formate = "yyyy-MM-dd";
		}
		sdf = new SimpleDateFormat(formate);
		return sdf.parse(date);
	}

	/*
	 * 获取当月的第一天
	 */
	public static Date getFirstDateOfManth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/*
	 * 获取当月的最后一天
	 */
	public static Date getLastDayOfManth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/*
	 * 获取当月的第一天
	 */
	public static Date getFirstDateOfManth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/*
	 * 获取当月的最后一天
	 */
	public static Date getLastDayOfManth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/*
	 * 得到当前年份
	 */
	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	public static void main(String[] args) throws Exception {

		System.out.println(MyDateUtil.getFormatedString("yyyyMMdd", new Date()));
	}

//    protected static Log logger = LogFactory.getLog(DateUtil.class);
    
    // 格式：年－月－日 小时：分钟：秒
    public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";
 
    // 格式：年－月－日 小时：分钟
    public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";
 
    // 格式：年月日 小时分钟秒
    public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";
 
    // 格式：年－月－日
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";
 
    // 格式：月－日
    public static final String SHORT_DATE_FORMAT = "MM-dd";
 
    // 格式：小时：分钟：秒
    public static final String LONG_TIME_FORMAT = "HH:mm:ss";
 
    //格式：年-月
    public static final String MONTG_DATE_FORMAT = "yyyy-MM";
 
    // 年的加减
    public static final int SUB_YEAR = Calendar.YEAR;
 
    // 月加减
    public static final int SUB_MONTH = Calendar.MONTH;
 
    // 天的加减
    public static final int SUB_DAY = Calendar.DATE;
 
    // 小时的加减
    public static final int SUB_HOUR = Calendar.HOUR;
 
    // 分钟的加减
    public static final int SUB_MINUTE = Calendar.MINUTE;
 
    // 秒的加减
    public static final int SUB_SECOND = Calendar.SECOND;
 
    static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六" };
 
    @SuppressWarnings("unused")
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
 
    public MyDateUtil() {
    }
 
    /**
     * 把符合日期格式的字符串转换为日期类型
     * 
     * @param dateStr
     * @return
     */
    public static java.util.Date stringtoDate(String dateStr, String format) {
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr);
        } catch (Exception e) {
            // log.error(e);
            d = null;
        }
        return d;
    }
 
    /**
     * 把符合日期格式的字符串转换为日期类型
     */
    public static java.util.Date stringtoDate(String dateStr, String format,
            ParsePosition pos) {
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr, pos);
        } catch (Exception e) {
            d = null;
        }
        return d;
    }
 
    /**
     * 把日期转换为字符串
     * 
     * @param date
     * @return
     */
    public static String dateToString(java.util.Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            // log.error(e);
        }
        return result;
    }
 
    /**
     * 获取当前时间的指定格式
     * 
     * @param format
     * @return
     */
    public static String getCurrDate(String format) {
        return dateToString(new Date(), format);
    }
 
    /**
     * 
     * @param dateStr
     * @param amount
     * @return
     */
    public static String dateSub(int dateKind, String dateStr, int amount) {
        Date date = stringtoDate(dateStr, FORMAT_ONE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateKind, amount);
        return dateToString(calendar.getTime(), FORMAT_ONE);
    }
    /**
     * yyyy-MM-dd
     * @param dateKind
     * @param dateStr
     * @param amount
     * @return
     */
    public static String dateSubDate(int dateKind, String dateStr, int amount) {
        Date date = stringtoDate(dateStr, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateKind, amount);
        return dateToString(calendar.getTime(), FORMAT_ONE);
    }
 
    /**
     * 两个日期相减
     * 
     * @param firstTime
     * @param secTime
     * @return 相减得到的秒数
     */
    public static long timeSub(String firstTime, String secTime) {
        long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
        long second = stringtoDate(secTime, FORMAT_ONE).getTime();
        return (second - first) / 1000;
    }
 
    /**
     * 获得某月的天数
     * 
     * @param year
     *          int
     * @param month
     *          int
     * @return int
     */
    public static int getDaysOfMonth(String year, String month) {
        int days = 0;
        if (month.equals("1") || month.equals("3") || month.equals("5")
                || month.equals("7") || month.equals("8") || month.equals("10")
                || month.equals("12")) {
            days = 31;
        } else if (month.equals("4") || month.equals("6") || month.equals("9")
                || month.equals("11")) {
            days = 30;
        } else {
            if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
                    || Integer.parseInt(year) % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }
 
        return days;
    }
 
    /**
     * 获取某年某月的天数
     * 
     * @param year
     *          int
     * @param month
     *          int 月份[1-12]
     * @return int
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
 
    /**
     * 获得当前日期
     * 
     * @return int
     */
    public static int getToday() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }
 
    /**
     * 获得当前月份
     * 
     * @return int
     */
    public static int getToMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }
 
    /**
     * 获得当前年份
     * 
     * @return int
     */
    public static int getToYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
 
    /**
     * 返回日期的天
     * 
     * @param date
     *          Date
     * @return int
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }
 
    /**
     * 返回日期的年
     * 
     * @param date
     *          Date
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
 
    /**
     * 返回日期的月份，1-12
     * 
     * @param date
     *          Date
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }
 
    /**
     * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
     * 
     * @param date1
     *          Date
     * @param date2
     *          Date
     * @return long
     */
    public static long dayDiff(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 86400000;
    }
 
    /**
     * 比较两个日期的年差
     * 
     * @param befor
     * @param after
     * @return
     */
    public static int yearDiff(String before, String after) {
        Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(afterDay) - getYear(beforeDay);
    }
 
    /**
     * 比较指定日期与当前日期的差
     * 
     * @param befor
     * @param after
     * @return
     */
    public static int yearDiffCurr(String after) {
        Date beforeDay = new Date();
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(beforeDay) - getYear(afterDay);
    }
     
    /**
     * 比较指定日期与当前日期的差
     * @param before
     * @return
     * @author chenyz
     */
    public static long dayDiffCurr(String before) {
        Date currDate = MyDateUtil.stringtoDate(currDay(), LONG_DATE_FORMAT);
        Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
        return (currDate.getTime() - beforeDate.getTime()) / 86400000;
 
    }
 
    /**
     * 获取每月的第一周
     * @param year
     * @param month
     * @return
     * @author chenyz
     */
    public static int getFirstWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }
 
    /**
     * 获取每月的最后一周
     * @param year
     * @param month
     * @return
     * @author chenyz
     */
    public static int getLastWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, getDaysOfMonth(year, month));
        return c.get(Calendar.DAY_OF_WEEK);
    }
 
    /**
     * 获得当前日期字符串，格式"yyyy_MM_dd_HH_mm_ss"
     * 
     * @return
     */
    public static String getCurrent() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        StringBuffer sb = new StringBuffer();
        sb.append(year).append("_").append(addzero(month, 2))
                .append("_").append(addzero(day, 2)).append("_")
                .append(addzero(hour, 2)).append("_").append(
                        addzero(minute, 2)).append("_").append(
                        addzero(second, 2));
        return sb.toString();
    }
 
    /**
     * 获得当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
     * 
     * @return
     */
    public static String getNow() {
        Calendar today = Calendar.getInstance();
        return dateToString(today.getTime(), FORMAT_ONE);
    }
 
    /**
     * 根据生日获取星座
     * 
     * @param birth
     *          YYYY-mm-dd
     * @return
     */
    public static String getAstro(String birth) {
        if (!isDate(birth)) {
            birth = "2000" + birth;
        }
        if (!isDate(birth)) {
            return "";
        }
        int month = Integer.parseInt(birth.substring(birth.indexOf("-") + 1,
                birth.lastIndexOf("-")));
        int day = Integer.parseInt(birth.substring(birth.lastIndexOf("-") + 1));
        String s = "魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
        int[] arr = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
        int start = month * 2 - (day < arr[month - 1] ? 2 : 0);
        return s.substring(start, start + 2) + "座";
    }
 
    /**
     * 判断日期是否有效,包括闰年的情况
     * 
     * @param date
     *          YYYY-mm-dd
     * @return
     */
    public static boolean isDate(String date) {
        StringBuffer reg = new StringBuffer(
                "^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
        reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
        reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
        reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
        reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
        reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
        reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
        Pattern p = Pattern.compile(reg.toString());
        return p.matcher(date).matches();
    }
 
    /**
     * 取得指定日期过 months 月后的日期 (当 months 为负数表示指定月之前);
     * 
     * @param date
     *          日期 为null时表示当天
     * @param month
     *          相加(相减)的月数
     */
    public static Date nextMonth(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
 
    /**
     * 取得指定日期过 day 天后的日期 (当 day 为负数表示指日期之前);
     * 
     * @param date
     *          日期 为null时表示当天
     * @param month
     *          相加(相减)的月数
     */
    public static Date nextDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DAY_OF_YEAR, day);
        return cal.getTime();
    }
 
    /**
     * 取得距离今天 day 日的日期
     * @param day
     * @param format
     * @return
     * @author chenyz
     */
    public static String nextDay(int day, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, day);
        return dateToString(cal.getTime(), format);
    }
 
    /**
     * 取得指定日期过 day 周后的日期 (当 day 为负数表示指定月之前)
     * 
     * @param date
     *          日期 为null时表示当天
     */
    public static Date nextWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.WEEK_OF_MONTH, week);
        return cal.getTime();
    }
 
    /**
     * 获取当前的日期(yyyy-MM-dd)
     */
    public static String currDay() {
        return MyDateUtil.dateToString(new Date(), MyDateUtil.LONG_DATE_FORMAT);
    }
 
    /**
     * 获取昨天的日期
     * 
     * @return
     */
    public static String befoDay() {
        return befoDay(MyDateUtil.LONG_DATE_FORMAT);
    }
 
    /**
     * 根据时间类型获取昨天的日期
     * @param format
     * @return
     * @author chenyz
     */
    public static String befoDay(String format) {
        return MyDateUtil.dateToString(MyDateUtil.nextDay(new Date(), -1), format);
    }
 
    /**
     * 获取明天的日期
     */
    public static String afterDay() {
        return MyDateUtil.dateToString(MyDateUtil.nextDay(new Date(), 1),
        		MyDateUtil.LONG_DATE_FORMAT);
    }
 
    /**
     * 取得当前时间距离1900/1/1的天数
     * 
     * @return
     */
    public static int getDayNum() {
        int daynum = 0;
        GregorianCalendar gd = new GregorianCalendar();
        Date dt = gd.getTime();
        GregorianCalendar gd1 = new GregorianCalendar(1900, 1, 1);
        Date dt1 = gd1.getTime();
        daynum = (int) ((dt.getTime() - dt1.getTime()) / (24 * 60 * 60 * 1000));
        return daynum;
    }
 
    /**
     * getDayNum的逆方法(用于处理Excel取出的日期格式数据等)
     * 
     * @param day
     * @return
     */
    public static Date getDateByNum(int day) {
        GregorianCalendar gd = new GregorianCalendar(1900, 1, 1);
        Date date = gd.getTime();
        date = nextDay(date, day);
        return date;
    }
 
    /** 针对yyyy-MM-dd HH:mm:ss格式,显示yyyymmdd */
    public static String getYmdDateCN(String datestr) {
        if (datestr == null)
            return "";
        if (datestr.length() < 10)
            return "";
        StringBuffer buf = new StringBuffer();
        buf.append(datestr.substring(0, 4)).append(datestr.substring(5, 7))
                .append(datestr.substring(8, 10));
        return buf.toString();
    }
 
    /**
     * 获取本月第一天
     * 
     * @param format
 
     * @return
     */
    public static String getFirstDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        return dateToString(cal.getTime(), format);
    }
    public static String getFirstDayOfYear(String format) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, year);
        return dateToString(cal.getTime(), format);
    }
 
    /**
     * 获取本月最后一天
     * 
     * @param format
     * @return
     */
    public static String getLastDayOfMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return dateToString(cal.getTime(), format);
    }
    public static String getLastDayOfYear(String format) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.roll(Calendar.DAY_OF_YEAR, -1);
        return dateToString(cal.getTime(), format);
    }
    /** 
     * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回 
     * @param sourceDate 
     * @param formatLength 
     * @return 重组后的数据 
     */  
    public static String addzero(int sourceDate,int formatLength)  
    {  
     /* 
      * 0 指前面补充零 
      * formatLength 字符总长度为 formatLength 
      * d 代表为正数。 
      */  
     String newString = String.format("%0"+formatLength+"d", sourceDate);  
     return  newString;  
    }  
    
    public static Timestamp timeForDatabase(String timeStr) throws Exception{
    	if(timeStr!=null&&!"".equals(timeStr)){
    		return new Timestamp(getDateFromStr("yyyy-MM-dd HH:mm:ss",timeStr).getTime());
    	}else{
    		return new Timestamp(new Date().getTime());
    	}
    } 
    
    public static String fromFormatToFormat(String dateStr, String fromFormat, String toFormat) throws Exception{
    	if(fromFormat==null || "".equals(fromFormat)){
    		fromFormat = "yyyy-MM-dd";
    	}
    	if(dateStr==null || "".equals(dateStr)){
    		return "";
    	}
    	Date date = getDateFromStr(fromFormat, dateStr);
    	return getFormatedString(toFormat, date);
    }
}
