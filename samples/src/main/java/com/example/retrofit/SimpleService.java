/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.MapBody;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public final class SimpleService {
  public static final String API_URL = "https://api.github.com";

  public static class Contributor {
    public final String login;
    public final int contributions;

    public Contributor(String login, int contributions) {
      this.login = login;
      this.contributions = contributions;
    }
  }

  public interface GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
  }

  public interface GitHub1 {

    @POST("http://localhost:9990/grandtechmap-collect-service-fs/api/test")
    Call<Map<String,Object>> contributors(@MapBody(value = "x") double x, @MapBody(value = "y") double y, @MapBody(value = "fullname") boolean isFullName);
  }
  public static void main(String... args) throws IOException {
    // Create a very simple REST adapter which points the GitHub API.
    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Create an instance of our GitHub API interface.
    GitHub1 github = retrofit.create(GitHub1.class);

    // Create a call instance for looking up Retrofit contributors.
 /*   Map<String,Object> map = new HashMap<>();
    map.put("aaa","ff");
    map.put("bbb",20);*/
   // String tk = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjozNCwidXNlcl9uYW1lIjoiaGVuYW5zIiwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6Ii9hcGkvdjEvc3lzVXNlci9wYWdlIn0seyJhdXRob3JpdHkiOiIvYXBpL3YxL2RhdGFEaXJlY3RvcnkvZ2V0VHJlZURpcmVjdG9yeSJ9XSwianRpIjoiMGM3OWY1Y2QtNDcwZi00NjZlLTg2YWEtZDdiNDRhMmViZDlmIiwiaWF0IjoxNjczODQ4Nzg4LCJleHAiOjE2NzM5MzUxODh9.jKbX7IM_AspG5E1RacWDWimC53qopdYzEzAqVZhQjln6YFDT2QE3asgbrrUxd-tSj-kOwE_AXIc5giaPBZUBBqZ4ICAMb-H_ijW94Ow-GSiq0irQ7aTJieJvzaC5WiFoPl9iLsrtJl27sBkUG7JRTP6fYmTpCsFEPhzbjiiIsZY7VH5W6VwUWKQzfESkgL7kv6iLY88OOipocbnKRU7cKtNt-GdRwRgQ7HlRG4RGXJ3_OowYpozVN8v1g155PZBAqjoyjDnCms_b-NJDuiW01-dvjwT78TJA76H4VFBZsmE5_SaQQ7oca2K3LmOHZ8Niyo-aFUG5RX-KNCsaq8YnLw";
//{"x":113.1907192,"y":31.304547,"fullname":true}
    Call<Map<String,Object>> call = github.contributors(113.1907192,31.304547,true);

    // Fetch and print a list of the contributors to the library.
    Map<String,Object> contributors = call.execute().body();
    System.out.println( " (" + contributors + ")");
  }
}
