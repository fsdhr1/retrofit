Retrofit

========

增加mapbody注解
 @POST("http://localhost:9990/grandtechmap-collect-service-fs/api/test")
    Call<Map<String,Object>> contributors(@MapBody(value = "x") double x, @MapBody(value = "y") double y, @MapBody(value = "fullname") boolean isFullName);
