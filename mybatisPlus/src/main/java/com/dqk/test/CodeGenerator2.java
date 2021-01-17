package com.dqk.test;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator2 {
    private static final Logger logger = LoggerFactory.getLogger(AutoGenerator.class);

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
//        AutoGenerator mpg = new MyAutoGenerator();
        AutoGenerator mpg = new AutoGenerator()/*{
            @Override
            public void execute() {
                logger.debug("==========================准备生成文件...==========================");
                // 初始化配置
                if (null == config) {
                    config = new MyConfigBuidler(getPackageInfo(), getDataSource(), getStrategy(), getTemplate(), getGlobalConfig());
                    if (null != injectionConfig) {
                        injectionConfig.setConfig(config);
                    }
                }
                if (null == getTemplateEngine()) {
                    // 为了兼容之前逻辑，采用 Velocity 引擎 【 默认 】
                    super.setTemplateEngine(new VelocityTemplateEngine());
                }
                // 模板引擎初始化执行文件输出
                getTemplateEngine().init(this.pretreatmentConfigBuilder(config)).mkdirs().batchOutput().open();
                logger.debug("==========================文件生成完成！！！==========================");

            }
        }*/;

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("dqk");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        /*gc.setIdType(IdType.NONE);*/
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        /*dsc.setUrl("jdbc:mysql://172.16.1.155:3306/wingto-cloud?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("dev");
        dsc.setPassword("Wingto@2020");*/
        dsc.setUrl("jdbc:mysql://129.211.65.95:3306/study?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Qq254497414.");

        dsc.setTypeConvert((globalConfig, fieldType) -> {
            String t = fieldType.toLowerCase();
            if (t.contains("timestamp")) {
                return DbColumnType.STRING;
            }
            if (t.startsWith("bigint")) {
                return DbColumnType.BIG_INTEGER;
            }
            //其它字段采用默认转换（非mysql数据库可以使用其它默认的数据库转换器）
            return new MySqlTypeConvert().processTypeConvert(globalConfig, fieldType);
        });

        /*        dsc.setDbQuery(new MySqlQuery() {

         *//**
         * 重写父类预留查询自定义字段<br>
         * 这里查询的 SQL 对应父类 tableFieldsSql 的查询字段，默认不能满足你的需求请重写它<br>
         * 模板中调用：  table.fields 获取所有字段信息，
         * 然后循环字段获取 field.customMap 从 MAP 中获取注入字段如下  NULL 或者 PRIVILEGES
         *//*
            @Override
            public String[] fieldCustom() {
                return new String[]{"NULL", "PRIVILEGES"};
            }
        });*/

        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        String 模块名 = scanner("模块名");
        //pc.setModuleName("test");
        pc.setParent("com.wingtoweb.apicenter");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseDto.class);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("remark");
        //String[] split = scanner("表名，多个英文逗号分割").split(",");
        strategy.setInclude("userinfo".split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");


        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
