package util;

import com.suzz.mini.constant.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author subo
 * @date 2022/5/19 11:34
 **/
public class SqlGenerateUtil {

    @Getter
    @AllArgsConstructor
    public enum dicEnum{

        A(1,"价格","chinese"),
        B(2,"电议","chinese"),
       // C(3,"已下架","chinese"),
/*        D(4,"集装箱","chinese"),
        E(5,"自卸","chinese"),
        F(6,"冷藏","chinese"),
        G(7,"保温","chinese"),
        H(8,"高低板","chinese"),
        I(9,"面包车","chinese"),
        J(10,"棉被车","chinese"),
        K(11,"爬梯车","chinese"),
        L(12,"飞翼车","chinese"),
        M(13,"依维柯","chinese"),
        N(14,"吊车","chinese"),*/
        ;

        private Integer key;

        private String value;

        private String lang;
    }

    @Getter
    @AllArgsConstructor
    public enum PageModuleEnum{

        A("page_bar_title","关注列表","chinese"),
        //A("service_complaints","服务投诉","chinese"),
/*        B("arrive_city","目的城市","chinese"),

     //  C("max_tonnage","最大吨数","chinese"),

        D("car_type_max_three","用车类型(最多三项)","chinese"),
        E("price_style","价格方式","chinese"),
        F("price","价格","chinese"),
        G("please_input_price","输入价格","chinese"),
        H("phone_meet","电议","chinese"),
        I("goods_info","货源信息","chinese"),
       // J("please_supple_info","请输入补充信息","chinese"),
        K("warm_prompt","温馨提示:发布的时间超过5天自动下架","chinese"),
       // L("publish","发布","chinese"),
        M("use_start_time","使用开始时间","chinese"),
        N("tonnage","吨位","chinese"),*/
        ;

        private String code;

        private String name;

        private String lang;
    }


    public static void main(String[] args) {
        generatePageModule();
        //generateDic();
    }

    public static void generatePageModule(){
        int id=46;
        int pageId=14;
        PageModuleEnum[] values = PageModuleEnum.values();
        for (PageModuleEnum pageModuleEnum : values) {
            String pageModule="INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES ("+id+", '"+pageId+"','"+pageModuleEnum.code+"');";
            System.out.println(pageModule);
            String pageModuleLang="INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES ("+id+", '"+pageModuleEnum.name+"', '"+pageModuleEnum.lang+"');";
            System.out.println(pageModuleLang);
            id++;
        }
    }

    public static void generateDic(){
        int id=18;
        String code="order_price_style";
        dicEnum[] values = dicEnum.values();
        for (dicEnum dicEnum : values) {
            String dic="INSERT INTO `suzz-mini`.`dictionary`(`id`, `code`, `key`) VALUES ("+id+", '"+code+"',"+dicEnum.key+" );";
            System.out.println(dic);
            String dicLang="INSERT INTO `suzz-mini`.`dictionary_lang`(`fk_dictionary`, `name`, `lang`) VALUES ("+id+", '"+dicEnum.value+"', '"+dicEnum.lang+"');";
            System.out.println(dicLang);
            id++;
        }
    }

    public static void generateException(){
        int id=1;
        ExceptionEnum exceptionEnum = ExceptionEnum.DEPARTURE_CITY_NOT_SELECTED;
        String lang ="chinese";
        String dic="INSERT INTO `suzz-mini`.`exception`(`id`, `code`) VALUES ("+id+", '"+exceptionEnum.getCode()+"');";
        System.out.println(dic);
        String dicLang="INSERT INTO `suzz-mini`.`exception_lang`(`fk_exception`, `name`, `lang`) VALUES ("+id+", '"+exceptionEnum.getName()+"', '"+lang+"');";
        System.out.println(dicLang);
    }
}
