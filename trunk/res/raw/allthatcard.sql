CREATE TABLE [SecretCard] (
  [_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT);

CREATE TABLE [CreditCard] (
  [_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  [card_company] TEXT NOT NULL, 
  [card_name] TEXT NOT NULL, 
  [card_number] TEXT NOT NULL, 
  [card_valid] TEXT NOT NULL, 
  [card_csv] TEXT NOT NULL, 
  [card_payment] TEXT, 
  [call_center] TEXT, 
  [memo] TEXT);

CREATE TABLE [BankAccount] (
  [_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
  [bank_company] TEXT NOT NULL, 
  [bank_name] TEXT NOT NULL, 
  [bank_person] TEXT NOT NULL, 
  [bank_number] TEXT NOT NULL, 
  [call_center] TEXT, 
  [memo] TEXT);

