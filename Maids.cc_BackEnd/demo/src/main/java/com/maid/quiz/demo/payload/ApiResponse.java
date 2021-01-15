package com.maid.quiz.demo.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T>{

	  private T data;
	    private String msg;


	    public static <T> ApiResponse<T> success(T data) {
	        return new ApiResponse<T>().setData(data);
	    }

}
