package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String uploadAndGetComments(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String comments, HttpSession session) {
        Image image = imageService.getImage(imageId);
        User user = (User) session.getAttribute("loggeduser");
        Comment comment = new Comment();
        comment.setText(comments);
        comment.setDate(LocalDate.now());
        comment.setUser(user);
        comment.setImage(image);
        commentService.uploadComments(comment);
        return "redirect:/images/" + imageId + "/" + imageTitle;
    }

}
