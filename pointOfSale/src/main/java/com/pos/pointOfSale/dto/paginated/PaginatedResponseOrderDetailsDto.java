package com.pos.pointOfSale.dto.paginated;

import com.pos.pointOfSale.dto.response.ResponseOrderDetailsDto;

import java.util.List;

public class PaginatedResponseOrderDetailsDto {
    private List<ResponseOrderDetailsDto> responseOrderDetailsDtoList;
    private long dataCount;

    @Override
    public String toString() {
        return "PaginatedResponseOrderDetailsDto{" +
                "responseOrderDetailsDtoList=" + responseOrderDetailsDtoList +
                ", dataCount=" + dataCount +
                '}';
    }

    public List<ResponseOrderDetailsDto> getResponseOrderDetailsDtoList() {
        return responseOrderDetailsDtoList;
    }

    public void setResponseOrderDetailsDtoList(List<ResponseOrderDetailsDto> responseOrderDetailsDtoList) {
        this.responseOrderDetailsDtoList = responseOrderDetailsDtoList;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public PaginatedResponseOrderDetailsDto(List<ResponseOrderDetailsDto> responseOrderDetailsDtoList, long dataCount) {
        this.responseOrderDetailsDtoList = responseOrderDetailsDtoList;
        this.dataCount = dataCount;
    }

    public PaginatedResponseOrderDetailsDto() {
    }
}
