package com.nhan.social.http;

public class Resources {

    private Resources() {}

    public static final String API_V1 = "/v1/social";

    public static class Job {

        private Job() {}
        public static final String HELLO = API_V1 + "/hello";
    }

    public static class User {
        private User() {}
        public static final String COLLECTION = API_V1 + "/user";
    }

}
