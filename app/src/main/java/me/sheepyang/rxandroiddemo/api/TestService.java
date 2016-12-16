package me.sheepyang.rxandroiddemo.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016-12-15.
 */

public interface TestService {
    //    params.put("currentPage", mCurrentPage + "");
//    params.put("pageSize", mPageSize + "");
//        params.put("fdRole", "");
//        params.put("fdUserId", "");
//        if (DataUtil.getLoginInfoBean().getFdCompanyName().equals("国网重庆市电力公司")) {
//    if (DataUtil.getLoginInfoBean().getFdCompanyLevel() == 0) {
//        params.put("fdCompanyName", DataUtil.getLoginInfoBean().getCompany());
//    } else {
//        params.put("fdCompanyName", DataUtil.getLoginInfoBean().getFdCompanyName());
//    }
//    params.put("fdFrom", mQueryFillter.workFrom);
//    params.put("fdLevel", mQueryFillter.level);
//    params.put("fdCarryInfo", mQueryFillter.bearing);
//    if (!TextUtils.isEmpty(mQueryFillter.workComplete))
//            params.put("fdCompletionStatus", mQueryFillter.workComplete);
//    params.put("orderby", "desc");
    @FormUrlEncoded
    @POST("task/taskList.ajax")
    Call<String> getTask(@Field("currentPage") String currentPage,
                         @Field("pageSize") String pageSize,
                         @Field("fdRole") String fdRole,
                         @Field("fdUserId") String fdUserId,
                         @Field("fdCompanyName") String fdCompanyName,
                         @Field("fdFrom") String fdFrom,
                         @Field("fdLevel") String fdLevel,
                         @Field("fdCarryInfo") String fdCarryInfo,
                         @Field("orderby") String desc);

//    void getRegion(@B);
}
