package global.sesoc.brr.vo;

import lombok.Data;

@Data
public class SnsReplyVO {
	
	private String snsReplynum;			//리플번호
	private String snsBoardnum;			//게시글번호
	private String id;					//작성자 ID
	private String email;				//작성자email
	private String comments;			//리플내용
	private String inputdate;			//작성날짜

}
