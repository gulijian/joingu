package com.gulj.entity.common.bo;

/**
 * redis-Key统一归集Bo
 */
public class RedisKeyBo {

    public static final String API_ACCESS_KEY_PREFIX = "access/";

    public static final String APP_INSTITU_ACCESS_KEY_PREFIX = "ins/access/";

    public static final String APP_AREA_LEVEL_ONE = "area/a/";

    public static final String APP_AREA_LEVEL_TWO = "area/b/";

    public static final String APP_AREA_LEVEL_THREE = "area/c/";

    public static final String API_WX_ACCESS_TOKEN = "wx/at/";

    public static final String API_WX_JS_API_TICKET = "wx/jsapiticket/";

    public static final String API_AUTH_HASH_KEY_ACCESS = "auth";

    public static final String APP_AUTH_HASH_KEY_UID = "uid";

    public static final String APP_AUTH_HASH_KEY_UNAME = "uname";

    public static final String APP_PROJECT_FILTER_CONFIG = "project/filter/config/";

    public static final String APP_AUTH_HASH_KEY_PHONE = "phone";

    public static final String API_AUTH_HASH_KEY_SECURITY = "security";

    public static final String API_AUTH_HASH_KEY_REFRESH_TOKEN = "rt";

    public static final String API_AUTH_REFRESH_TOKEN_KEY_PREFIX = "auth/rt/";

    public static final String API_INQUIRY_ISSUE_TICKET_PREFIX = "ticket/inquiry/";

    public static final String API_PROFILE_FEEDBACK_TICKET_PREFIX = "ticket/profile/";

    public static final String API_COMPLAINTS_SPACE_TICKET_PREFIX = "ticket/complaint/";

    public static final String API_COMMENT_TICKET_PREFIX = "ticket/comment/";

    public static final String API_TASK_FRESHER_PREFIX = "task/fresher/";

    public static final String API_ISSUE_REPLY_NUM_PREFIX = "issue/rn/";

    public static final String API_ADVISER_APPLY_PREFIX = "ticket/apply/";

    public static final String API_INQUIRY_REPLY_PREFIX = "ticket/inquiry/";

    public static final String API_TICKET_OPINION_PREFIX = "ticket/opinion/";

    public static final String ASSEMBLY_CAPTCHA = CacheModule.ASSEMBLY.getName() + "captcha/";

    public static final String ASSEMBLY_SENSITIVE_WORD = CacheModule.ASSEMBLY.getName() + "sw/";

    public static final String NOTICE_PUSH_KEY = "push/";

    public final static String EMAIL_CODE_REDIS_KEY_PREFIX = "eml/code/";

    public final static String SMS_CODE_REDIS_KEY_PREFIX = "sms/code/";

    public final static String SMS_CODE_HASH_KEY_CODE = "code";

    public final static String SMS_CODE_HASH_KEY_TIMESTAMP = "timestamp";

    public static final String MODULE_MARKET_EVENT_KEY = "market/event/";

    public static final String MODULE_MARKET_PLAN_KEY = "market/plan/";

    public static final String MODULE_MARKET_PLAN_RT_KEY = "market/plan/rt/";

    public static final String MODULE_MARKET_EVENT_RT_KEY = "market/event/rt/";

    public static final String MODULE_INQUIRY_ADVISER_COIN_KEY = "inquiry/adviser/coin/";

    public static final String MODULE_INQUIRY_PLAN_COIN_KEY = "inquiry/plan/coin/";


    public static final String MODULE_REGISTER_STEP_KEY = "reg/1/";


    public static final String FINANCE_STOCK_BASE_INFO_KEY = "s/b";

    public static final String FINANCE_STOCK_INDEX_INFO_BANNER = "s/idx/banner";

    public static final String FINANCE_STOCK_TICK_RT_SNAPSHOT_KEY_PREFIX = "s/snapshot";

    public static final String FINANCE_STOCK_TRADE_DAY_PREFIX = "s/tday/";

    public static final String IM_ACCESS_TOKEN_KEY = CacheModule.ASSEMBLY.getName() + "im/at/key/";

    public static final String IM_ACCESS_TOKEN = "at";

    public static final String IM_ACCESS_TOKEN_EXPIRE_TIME = "et";

    public static final String SERVER_INQUIRY_INFO = "inquiry/info/";

    public static final String APP_GROUP_XX = "gp/xx/";

    public static final String APP_INSTITU_PC_PHONE = "p";


    public static final long APP_REDIS_TIMEOUT = 168 * 60 * 60;

    /**
     * app存储member信息的key
     */
    public static final String APP_INSTITU_MEMBER = "/member";


    /**
     * 缓存模块名
     */
    public enum CacheModule {
        API("api/"), ASSEMBLY("asb/"), COMPONENT("cmp/"), MODULE("mod/"), FINANCE("fin/"), MGT("mgt/"), APP(
                "app/"), SERVER("server/"), COMMON("common/"), ANNOTATION("annot/"),PC("pc/");

        private String name;

        CacheModule(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
