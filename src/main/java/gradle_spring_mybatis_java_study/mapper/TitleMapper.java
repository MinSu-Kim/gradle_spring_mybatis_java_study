package gradle_spring_mybatis_java_study.mapper;

import java.util.List;

import gradle_spring_mybatis_java_study.dto.Title;

public interface TitleMapper {
    int deleteTitle(Title title);
    int insertTitle(Title title);
    Title selectTitleByNo(Title title);
    List<Title> selectTitleByAll();
    int updateTitle(Title title);
}
