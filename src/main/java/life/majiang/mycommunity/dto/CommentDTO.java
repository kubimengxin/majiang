package life.majiang.mycommunity.dto;

import lombok.Data;

/**
 * @author 苦逼萌新
 * @date 4/12/2020
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;

}
