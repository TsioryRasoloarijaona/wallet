create table account(
    account_id serial primary key ,
    account_number bigint unique,
    currency_id int references currency (currency_id),
    balance float
);