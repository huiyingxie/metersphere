package io.metersphere.testin.dto;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 18:33
 */
public class ResultDto {
   private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "result='" + result + '\'' +
                '}';
    }
}
