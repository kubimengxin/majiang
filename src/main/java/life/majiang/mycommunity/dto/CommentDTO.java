package life.majiang.mycommunity.dto;

import life.majiang.mycommunity.model.User;
import lombok.Data;

/**
 * @author 苦逼萌新
 * @date 4/12/2020
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private Integer commentCount;

    private String content;

    private User user;
}
