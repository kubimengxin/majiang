package life.majiang.mycommunity.mapper;

import life.majiang.mycommunity.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}