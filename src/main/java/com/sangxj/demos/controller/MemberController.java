package com.sangxj.demos.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sangxj.demos.dao.MemberMapper;
import com.sangxj.demos.entity.Member;
import com.sangxj.demos.service.MemberService;
import com.sangxj.demos.utils.SnowflakeIdWorker;
import com.sangxj.demos.vo.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


@RestController
@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
@Api(description = "Test")
public class MemberController {

    private Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Value("${workerId}")
    private long workerId;

    @Value("${dataCenterId}")
    private long dataCenterId;

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberService memberService;

    @PostMapping("testMybatisPlus")
    @ApiOperation(value = "会员插入测试")
    public RestResult testMybatisPlus() {
        Member member = new Member();
        member.setMemberId(new SnowflakeIdWorker(workerId, dataCenterId).nextId());
        member.setNickname("测试号");
        member.setAddress("湖南郴州");
        member.setTelephone("15899790993");
        memberMapper.insert(member);
        return new RestResult(member);
    }

    @PostMapping("testRequestBody")
    @ApiOperation(value = "测试1")
    public RestResult testRequestBody(@RequestBody Member member) {
        return new RestResult(member);
    }

    //java.time包测试
    @Test
    public void subTest1() {
        System.out.println("当前日期" + LocalDate.now());//当前日期
        System.out.println("当前时间" + LocalTime.now().withNano(0));//当前日期
        System.out.println("指定时间" + LocalTime.parse("12:00:01"));//当前日期
        System.out.println("当前时间加两小时" + LocalTime.now().plusHours(2).withNano(0));//当前日期
        LocalDate today = LocalDate.now();
        LocalDate specialDate = LocalDate.of(2008, 03, 04);
        System.out.println("当前时间是否比指定时间早" + today.isAfter(specialDate));//当前日期
        //当前时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone);
        //查看美国纽约当前的时间
        //查看美国纽约当前的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now();
        LocalDateTime americaDateTime = LocalDateTime.now(america);
        System.out.println(shanghaiTime);
        System.out.println(americaDateTime);
        //带有时区的时间
        ZonedDateTime americaZoneDateTime = ZonedDateTime.now(america);
        System.out.println(americaZoneDateTime);


        //比较两个时间之前时间差
        LocalDate today1 = LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2015, 10, 2);
        Period period = Period.between(specifyDate, today);
        System.out.println(period.getDays());  //4
        System.out.println(period.getMonths()); //1
        System.out.println(specifyDate.until(today, ChronoUnit.MONTHS));

        //日期时间格式解析、格式化
        String specifyDate1 = "20181129";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate formatted = LocalDate.parse(specifyDate1, formatter);
        System.out.println(formatted);

        //java8 时间类与Date类的相互转化

        //Date与Instant的相互转化
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant instant2 = date.toInstant();

        //Date转为LocalDateTime
        Date date2 = new Date();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());

        //LocalDateTime转Date
        LocalDateTime localDateTime3 = LocalDateTime.now();
        Instant instant3 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("当前时间戳" + instant3);
        Date date3 = Date.from(instant);

        //LocalDate转Date
        //因为LocalDate不包含时间，所以转Date时，会默认转为当天的起始时间，00:00:00
        LocalDate localDate4 = LocalDate.now();
        Instant instant4 = localDate4.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date4 = Date.from(instant);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(Instant.now());

        System.out.println(Timestamp.valueOf(LocalDateTime.now()));

    }

    @Test
    public void subTest() {
        List<String> phone = new ArrayList<>();
        phone.add("三星");    //索引为0
        phone.add("苹果");    //索引为1
        phone.add("锤子");    //索引为2
        phone.add("华为");    //索引为3
        phone.add("小米");    //索引为4
        //原list进行遍历
        for (String pho : phone) {
            System.out.println(pho);
        }
        //生成新list
        phone = phone.subList(1, 4);  //.subList(fromIndex, toIndex)      //利用索引1-4的对象重新生成一个list，但是不包含索引为4的元素，4-1=3
        for (int i = 0; i < phone.size(); i++) { // phone.size() 该方法得到list中的元素数的和
            System.out.println("新的list包含的元素是" + phone.get(i));
        }
    }

    @Test
    public void testAfterSeven() {
        Timestamp time = Timestamp.from(Instant.now());
        LocalDateTime localDateTime = time.toLocalDateTime();
        LocalDateTime.now().isAfter(localDateTime);
    }

    @GetMapping(value = "/getMemberList")
    @ApiOperation(value = "会员分页列表")
    public RestResult getMemberList(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        IPage<Member> memberIPage = memberMapper.selectPage(new Page<>(currentPage, pageSize), new QueryWrapper<>());
        return new RestResult(memberIPage);
    }

    //测试ActiveRecord方式
    @GetMapping(value = "testActiveRecord")
    @ApiOperation(value = "测试ActiveRecord方式")
    public RestResult testActiveRecord() {
        Member member = new Member();
        IPage<Member> memberPage = member.selectPage(new Page<>(1, 10), new QueryWrapper<>());
        LOGGER.info(memberPage.toString());
        return new RestResult(memberPage);
    }

}
