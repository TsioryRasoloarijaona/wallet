create table transaction (
    transaction_id serial primary key ,
    provider bigint references account (account_number),
    receiver bigint references account (account_number),
    value float,
    date date default current_date
);