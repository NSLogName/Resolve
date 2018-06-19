### 所需表结构

-- auto-generated definition
create table t_resolve_log
(
  id              int auto_increment
    primary key,
  invoke_url      varchar(100) null
  comment '接口地址',
  invoke_param    longtext     null
  comment '接口调用参数',
  invoke_result   longtext     null
  comment '接口返回参数',
  invoke_passtime int          null
  comment '接口耗时',
  invoke_time     varchar(50)  null
  comment '接口调用时间',
  memo            varchar(50)  null
  comment '备注',
  create_time     varchar(20)  null
  comment '创建时间',
  constraint t_resolve_log_id_uindex
  unique (id)
)
  comment '线上环境接口日志解析';

create index index_name
  on t_resolve_log (invoke_time);