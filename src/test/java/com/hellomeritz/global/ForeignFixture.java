package com.hellomeritz.global;

import com.hellomeritz.member.controller.dto.request.ForeignInfoSaveRequest;
import com.hellomeritz.member.service.dto.result.ForeignCreateResult;
import com.hellomeritz.member.service.dto.result.ForeignInfoSaveResult;
import com.hellomeritz.member.service.dto.result.ForeignSaveIpAddressResult;
import com.hellomeritz.member.service.dto.result.UserCheckIsFcResult;

public class ForeignFixture {

    private ForeignFixture() {
        throw new AssertionError("생성자를 통해서 인스턴스를 생성할 수 없습니다.");
    }

    public static ForeignCreateResult foreignCreateResult() {
        return new ForeignCreateResult(1L);
    }

    public static ForeignInfoSaveResult foreignInfoSaveResult() {
        return new ForeignInfoSaveResult(
                1L
        );
    }

    public static ForeignInfoSaveRequest foreignInfoSaveRequest() {
        return new ForeignInfoSaveRequest(
                "US",
                "E1",
                true,
                "19970121"
        );
    }

    public static ForeignSaveIpAddressResult foreignSaveIpAddressResult() {
        return new ForeignSaveIpAddressResult(
                "127.0.0.1"
        );
    }

    public static UserCheckIsFcResult userCheckIsFcResult() {
        return new UserCheckIsFcResult(true);
    }
}
