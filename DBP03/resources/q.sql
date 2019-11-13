
CREATE SEQUENCE s_cart_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE SEQUENCE s_category_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE SEQUENCE s_exchange_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE SEQUENCE s_m_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE SEQUENCE s_order_detail_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE SEQUENCE s_order_id
	INCREMENT BY 1
	START WITH 10

Execution Successful


CREATE SEQUENCE s_product_id
	INCREMENT BY 1
	START WITH 1000

Execution Successful


CREATE SEQUENCE s_review_id
	INCREMENT BY 1
	START WITH 1

Execution Successful


CREATE TABLE product
(
	product_id           INT NOT NULL ,
	effect               VARCHAR2(220) NOT NULL ,
	p_name               VARCHAR2(30) NOT NULL ,
	p_price              INT NOT NULL ,
	category_id          INT NOT NULL ,
	order_detail_id      INT NULL ,
	order_id             INT NULL ,
	m_id                 INT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKproduct ON product
(product_id   ASC)

Execution Successful


ALTER TABLE product
	ADD CONSTRAINT  XPKproduct PRIMARY KEY (product_id)

Execution Successful


CREATE TABLE cart
(
	m_id                 INT NOT NULL ,
	cart_p_num           INT NOT NULL ,
	c_price              INT NULL ,
	product_id           INT NOT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKcart ON cart
(m_id   ASC,product_id   ASC)

Execution Successful


ALTER TABLE cart
	ADD CONSTRAINT  XPKcart PRIMARY KEY (m_id,product_id)

Execution Successful


CREATE TABLE category
(
	category_id          INT NOT NULL ,
	c_name               VARCHAR2(30) NOT NULL ,
	c_detail             VARCHAR2(100) NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKcategory ON category
(category_id   ASC)

Execution Successful


ALTER TABLE category
	ADD CONSTRAINT  XPKcategory PRIMARY KEY (category_id)

Execution Successful


CREATE TABLE member
(
	m_id                 INT NOT NULL ,
	m_name               VARCHAR2(10) NOT NULL ,
	m_password           VARCHAR2(16) NOT NULL ,
	email_id             VARCHAR2(30) NULL ,
	address              VARCHAR2(50) NOT NULL ,
	phone                CHAR(11) NOT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKmember ON member
(m_id   ASC)

Execution Successful


ALTER TABLE member
	ADD CONSTRAINT  XPKmember PRIMARY KEY (m_id)

Execution Successful


CREATE TABLE review
(
	m_id                 INT NOT NULL ,
	product_id           INT NOT NULL ,
	review_id            CHAR(18) NOT NULL ,
	rate                 INT NULL ,
	review               VARCHAR2(100) NULL ,
	write_time           DATE NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKreview ON review
(review_id   ASC)

Execution Successful


ALTER TABLE review
	ADD CONSTRAINT  XPKreview PRIMARY KEY (review_id)

Execution Successful


CREATE TABLE order_detail
(
	product_id           INT NOT NULL ,
	order_detail_id      INT NOT NULL ,
	order_id             INT NOT NULL ,
	total_price          INT NOT NULL ,
	o_amount             INT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKorder_detail ON order_detail
(order_detail_id   ASC,order_id   ASC)

Execution Successful


ALTER TABLE order_detail
	ADD CONSTRAINT  XPKorder_detail PRIMARY KEY (order_detail_id,order_id)

Execution Successful


CREATE TABLE order_p
(
	order_id             INT NOT NULL ,
	m_id                 INT NULL ,
	order_state          VARCHAR2(10) NOT NULL ,
	order_date           DATE NOT NULL ,
	address              VARCHAR2(50) NOT NULL ,
	total_price          INT NOT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKorder_p ON order_p
(order_id   ASC,total_price   ASC)

Execution Successful


ALTER TABLE order_p
	ADD CONSTRAINT  XPKorder_p PRIMARY KEY (order_id,total_price)

Execution Successful


CREATE TABLE recommandation
(
	m_id                 INT NOT NULL ,
	order_detail_id      INT NOT NULL ,
	order_id             INT NOT NULL ,
	recomm_time          DATE NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKrecommandation ON recommandation
(m_id   ASC)

Execution Successful


ALTER TABLE recommandation
	ADD CONSTRAINT  XPKrecommandation PRIMARY KEY (m_id)

Execution Successful


CREATE TABLE exchange
(
	exchange_id          CHAR(18) NOT NULL ,
	m_id                 INT NULL ,
	exchange_date        DATE NULL ,
	exchange_status      VARCHAR2(10) NULL ,
	order_id             INT NULL ,
	total_price          INT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKexchange ON exchange
(exchange_id   ASC)

Execution Successful


ALTER TABLE exchange
	ADD CONSTRAINT  XPKexchange PRIMARY KEY (exchange_id)

Execution Successful


CREATE TABLE exchange_list
(
	exchange_id          CHAR(18) NOT NULL ,
	order_detail_id      INT NULL ,
	order_id             INT NULL ,
	product_id           INT NULL 
)

Execution Successful


CREATE UNIQUE INDEX XPKexchange_list ON exchange_list
(exchange_id   ASC)

Execution Successful


ALTER TABLE exchange_list
	ADD CONSTRAINT  XPKexchange_list PRIMARY KEY (exchange_id)

Execution Successful


ALTER TABLE product
	ADD (CONSTRAINT category_product FOREIGN KEY (category_id) REFERENCES category (category_id))

Execution Successful


ALTER TABLE product
	ADD (CONSTRAINT R_43 FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE SET NULL)

ORA-02275: 참조 제약이 이미 테이블에 존재합니다

Execution Failed!


ALTER TABLE product
	ADD (CONSTRAINT R_44 FOREIGN KEY (order_detail_id, order_id) REFERENCES order_detail (order_detail_id, order_id) ON DELETE SET NULL)

Execution Successful


ALTER TABLE product
	ADD (CONSTRAINT R_48 FOREIGN KEY (m_id, product_id) REFERENCES cart (m_id, product_id) ON DELETE SET NULL)

Execution Successful


ALTER TABLE cart
	ADD (CONSTRAINT m_cart FOREIGN KEY (m_id) REFERENCES member (m_id))

Execution Successful


ALTER TABLE cart
	ADD (CONSTRAINT R_49 FOREIGN KEY (product_id) REFERENCES product (product_id))

Execution Successful


ALTER TABLE review
	ADD (CONSTRAINT R_46 FOREIGN KEY (m_id) REFERENCES member (m_id))

Execution Successful


ALTER TABLE review
	ADD (CONSTRAINT R_47 FOREIGN KEY (product_id) REFERENCES product (product_id))

Execution Successful


ALTER TABLE order_detail
	ADD (CONSTRAINT odetaillist FOREIGN KEY (product_id) REFERENCES product (product_id))

Execution Successful


ALTER TABLE order_detail
	ADD (CONSTRAINT olist_odetaillist FOREIGN KEY (order_id, total_price) REFERENCES order_p (order_id, total_price))

Execution Successful


ALTER TABLE order_p
	ADD (CONSTRAINT m_olist FOREIGN KEY (m_id) REFERENCES member (m_id))

Execution Successful


ALTER TABLE order_p
	ADD (CONSTRAINT R_42 FOREIGN KEY (m_id) REFERENCES member (m_id) ON DELETE SET NULL)

ORA-02275: 참조 제약이 이미 테이블에 존재합니다

Execution Failed!


ALTER TABLE recommandation
	ADD (CONSTRAINT m_recomm FOREIGN KEY (m_id) REFERENCES member (m_id))

Execution Successful


ALTER TABLE recommandation
	ADD (CONSTRAINT odetaillist_recomm FOREIGN KEY (order_detail_id, order_id) REFERENCES order_detail (order_detail_id, order_id))

Execution Successful


ALTER TABLE exchange
	ADD (CONSTRAINT R_51 FOREIGN KEY (m_id) REFERENCES recommandation (m_id) ON DELETE SET NULL)

Execution Successful


ALTER TABLE exchange
	ADD (CONSTRAINT R_53 FOREIGN KEY (m_id) REFERENCES member (m_id) ON DELETE SET NULL)

Execution Successful


ALTER TABLE exchange
	ADD (CONSTRAINT R_55 FOREIGN KEY (order_id, total_price) REFERENCES order_p (order_id, total_price) ON DELETE SET NULL)

Execution Successful


ALTER TABLE exchange_list
	ADD (CONSTRAINT R_60 FOREIGN KEY (exchange_id) REFERENCES exchange (exchange_id))

Execution Successful


ALTER TABLE exchange_list
	ADD (CONSTRAINT R_63 FOREIGN KEY (product_id) REFERENCES product (product_id) ON DELETE SET NULL)

Execution Successful


ALTER TABLE exchange_list
	ADD (CONSTRAINT R_66 FOREIGN KEY (order_detail_id, order_id) REFERENCES order_detail (order_detail_id, order_id) ON DELETE SET NULL)

Execution Successful

Schema Generation Complete
56 queries succeeded.  2 queries failed.  
