package life.majiang.mycommunity.service;

import life.majiang.mycommunity.enums.CommentTypeEnum;
import life.majiang.mycommunity.exception.CustomizeErrorCode;
import life.majiang.mycommunity.exception.CustomizeException;
import life.majiang.mycommunity.mapper.CommentMapper;
import life.majiang.mycommunity.mapper.QuestionExtMapper;
import life.majiang.mycommunity.mapper.QuestionMapper;
import life.majiang.mycommunity.model.Comment;
import life.majiang.mycommunity.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 苦逼萌新
 * @date 4/12/2020
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if(comment.getType().equals(CommentTypeEnum.COMMENT.getType())){
            //回复评论
            Comment DBComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if(DBComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if(question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
