package toy.playvip.post.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.playvip.board.domain.Board;
import toy.playvip.common.Timestamped;
import toy.playvip.user.domain.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId")
    private User user;

    // Join테이블이 Json결과에 표시되지 않도록 처리
    protected Board getBoard(){
        return board;
    }

    public Post(String author, String title, String content, Board board, User user) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.board = board;
        this.user = user;
    }

    public Post setUpdate(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
        return this;
    }
}
