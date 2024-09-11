//package org.glimmer.domain;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.tika.config.Field;
//import org.springframework.data.annotation.Id;
//
//public class Lunece {
//}
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Document(indexName = "product")
//public class Lunece {
//    @Id
//    private Long id;
//
//    @Field(type = FieldType.Keyword)
//    private String name;
//
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String description;
//
//    @Field(type = FieldType.Long)
//    private Long jobId;
//
//    @Field(type = FieldType.Keyword)
//    private String category;
//
//    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
//    private Date createTime;
//}