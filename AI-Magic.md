## 数据库设计文档

| 序号 | 数据表名            | 中文名称 |
| --- | ------------------- | ----------- |
|  1  | users               | 用户表 |
|  2  | user_profiles       | 用户资料表 |
|  3  | models              | 模型表 |
|  4  | model_tags          | 模型标签表     |
|  5  | model_tags_relation | 模型-标签关系表 |

## 用户表 (users)

| 序号 | 数据字段名 | 数据类型 | 中文名称 | 说明 |
| --- | ------------- | ------------ | ----------- | --- |
|  1  | user_id       | char(36)     | 用户ID       | 主键，UUID |
|  2  | account       | varchar(45)  | 账号         | 唯一 |
|  3  | password_hash | varchar(255) | 密码哈希     | 加密存储 |
|  4  | username      | varchar(50)  | 用户名       | 唯一 |
|  5  | phone         | varchar(11)  | 手机号       | 可选 |
|  6  | email         | varchar(45)  | 邮箱         | 可选 |
|  7  | created_at    | timestamp    | 创建时间     | 默认当前时间 |
|  8  | last_login    | timestamp    | 最后登录时间 | 可选 |
|  9  | status        | tinyint      | 账号状态     | 默认1(正常) |

## 用户资料表 (user_profiles)

| 序号 | 数据字段名 | 数据类型 | 中文名称 | 说明 |
| --- | ---------- | ------------ | --------- | --- |
|  1  | profile_id | int          | 资料ID    | 主键，自增 |
|  2  | user_id    | char(36)     | 用户ID    | 外键关联users表 |
|  3  | avatar_url | varchar(255) | 头像url   | 可选 |
|  4  | cover_url  | varchar(255) | 封面url   | 可选 |
|  5  | intro      | varchar(50)  | 简介      | 可选 |

## 模型表 (models)

| 序号 | 数据字段名 | 数据类型 | 中文名称 | 说明 |
| --- | -------------- | ------------ | ----------- | --- |
|  1  | model_id       | char(36)     | 模型ID       | 主键，UUID |
|  2  | name           | varchar(30)  | 模型名称     | 必填 |
|  3  | creator_id     | char(36)     | 创建者ID     | 外键关联users表 |
|  4  | cover_url      | varchar(255) | 封面图URL    | 可选 |
|  5  | model_url      | varchar(255) | 模型文件URL  | 必填 |
|  6  | description    | text         | 模型描述     | 可选 |
|  7  | type           | varchar(20)  | 模型类型     | 可选 |
|  8  | category       | varchar(20)  | 模型分类     | 可选 |
|  9  | tags           | text         | 标签         | 暂定 |
|  10 | created_at     | timestamp    | 创建时间     | 默认当前时间 |
|  11 | last_update    | timestamp    | 最后更新时间 | 自动更新 |
|  12 | model_size     | int          | 模型大小     | 可选，单位byte |
|  13 | download_count | int          | 下载次数     | 默认0 |
|  14 | like_count     | int          | 点赞数       | 默认0 |
|  15 | status         | tinyint      | 模型状态     | 默认1(正常) |

## 模型标签表 (model_tags)

| 序号 | 数据字段名 | 数据类型 | 中文名称 | 说明 |
| --- | ------ | ----------- | ------ | --- |
|  1  | tag_id | int         | 标签ID | 主键，自增 |
|  2  | name   | varchar(50) | 标签名 | 唯一 |

## 模型-标签关系表 (model_tags_relation)

| 序号 | 数据字段名 | 数据类型 | 中文名称 | 说明 |
| --- | -------- | -------- | ------ | ------------------------ |
|  1  | model_id | char(36) | 模型id | 联合主键，外键关联models表 |
|  2  | tag_id   | int      | 标签id | 联合主键，外键关联model_tags表 |
