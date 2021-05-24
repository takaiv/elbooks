# elbooks_db testdata


USE elbooks;

CREATE TABLE m_category(
    category_id int(4) AUTO_INCREMENT NOT NULL,
    category varchar(99) UNIQUE,
    entry_day datetime DEFAULT CURRENT_TIMESTAMP,
    updatetime datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    isdeleted int(1) DEFAULT 0,

    index fk_category_id(category_id),
    primary key(category_id)
);

insert into m_category(
category
)values(
"Java"
);

insert into m_category(
category
)values(
"Spring"
);

CREATE TABLE m_book(
    book_id int(4) AUTO_INCREMENT NOT NULL,
    title varchar(99),
    author varchar(20),

    category_id int(2),
    foreign key fk_category_id(category_id) REFERENCES m_category(category_id),

    max_num int(2),
    entry_day datetime DEFAULT CURRENT_TIMESTAMP,
    updatetime datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    isdeleted int(1) DEFAULT 0,
    page int(255),

    index fk_book_id(book_id),
    primary key(book_id)
);

insert into m_book(
title,
author,
category_id,
max_num,
page
)values(
"Java入門",
"著者さん",
1,
99,
473
);

insert into m_book(
title,
author,
category_id,
max_num,
page
)values(
"Spring入門",
"著者さん",
2,
99,
723
);

CREATE TABLE m_user(
    user_id int(4) AUTO_INCREMENT,
    user_name varchar(20),
    mail varchar(256) UNIQUE,
    pass varchar(16) DEFAULT "9999",
    admin_flg int(1) DEFAULT 0,
    join_day datetime,
    entry_day datetime DEFAULT CURRENT_TIMESTAMP,
    updatetime datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    isdeleted int(1) DEFAULT 0,

    index fk_user_id(user_id),
    primary key(user_id)
);

insert into m_user(
user_name,
mail,
pass,
admin_flg,
join_day
)values(
"testname",
"test@el-ltd.co.jp",
"testpass",
1,
"2021-4-1"
);

insert into m_user(
user_name,
mail,
pass,
join_day
)values(
"testname2",
"test2@el-ltd.co.jp",
"testpass2",
"2021-4-1"
);

insert into m_user(
user_name,
mail,
pass
)values(
"testname2",
"test2@el-ltd.co.jp",
"testpass2"
);

insert into m_user(
user_name,
mail,
pass
)values(
"testname4",
"test4@el-ltd.co.jp",
"testpass4"
);

insert into m_user(
user_name,
mail,
pass,
isdeleted
)values(
"testname5",
"test5@el-ltd.co.jp",
"testpass5",
1
);

CREATE TABLE t_loan(
    book_id int(4) NOT NULL,
    user_id int(4) NOT NULL,
    foreign key fk_book_id(book_id) REFERENCES m_book(book_id),
    foreign key fk_user_id(user_id) REFERENCES m_user(user_id),

    loan_day datetime DEFAULT CURRENT_TIMESTAMP,
    plan_day datetime NOT NULL,

    primary key(book_id,user_id)
);

insert into t_loan(
book_id,
user_id,
plan_day
)values(
1,
1,
"2021-03-30"
);

insert into t_loan(
book_id,
user_id,
plan_day
)values(
2,
1,
"2021-09-20"
);

CREATE TABLE t_history(
    book_id int(4) NOT NULL,
    user_id int(4) NOT NULL,
    
    loan_day datetime,
    return_day datetime DEFAULT CURRENT_TIMESTAMP,

    primary key(book_id,user_id),
    foreign key fk_book_id(book_id) REFERENCES m_book(book_id),
    foreign key fk_user_id(user_id) REFERENCES m_user(user_id)
);

CREATE TABLE t_inquiry(
    inquiry_id int(5) AUTO_INCREMENT NOT NULL,
    user_id int(4),
    category_id int(4),
    inquiry_contents varchar(999) ,
    inquiry_day datetime DEFAULT CURRENT_TIMESTAMP,

    primary key(inquiry_id),
    foreign key fk_user_id(user_id) REFERENCES m_user(user_id),
    foreign key fk_category_id(category_id) REFERENCES m_category(category_id)
);

insert into t_inquiry(
user_id,
category_id,
inquiry_contents
)values(
2,
2,
"spring入門の在庫に3冊追加したいです"
);
