# --- !Ups

CREATE TABLE users(
  id TEXT NOT NULL PRIMARY KEY,
  email TEXT NOT NULL,
  password TEXT NOT NULL,
  created_at timestamp default current_timestamp
);

# --- !Downs

drop table users;
