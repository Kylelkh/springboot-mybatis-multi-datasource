create table default.user
(
    user_id Nullable(Int32),
    user_name Nullable(String)
)
    engine = Memory;


-- 测试map字段的查询
CREATE TABLE your_table (
                            id UInt32,
                            name String,
                            age UInt8,
                            data Map(String, String)
) ENGINE = MergeTree()
      ORDER BY id;


INSERT INTO your_table (id, name, age, data)
VALUES (1, 'John', 25, {'key1': 'value1'});

INSERT INTO your_table (id, name, age, data)
VALUES (2, 'Alice', 30, {'key2': 'value2'});

INSERT INTO your_table (id, name, age, data)
VALUES (3, 'Bob', 35, {'key3': 'value3'});

INSERT INTO your_table (id, name, age, data)
VALUES (1, 'Kyle', 25, {'key1': 'value1', 'key2': '3', 'key3': 'value3'});

INSERT INTO your_table (id, name, age, data)
VALUES (5, 'Kyle', 25, {'key1': 'value1', 'key2': '4', 'key3': 'value3'});