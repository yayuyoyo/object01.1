INSERT INTO m_user
    (user_name, password, mailAddress, birthYear, birthMonth, birthday, gender, role)
VALUES('sajisaji', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'mail@co.jp', '1995', '4', '8', true, 'ROLE_ADMIN');


-- insert into w_data
--     (recordYear, recordMonth, recordDay,recordWeight)
-- values('2021', '2', '22', '66.4');


INSERT INTO w_data
    (
    recordDate, recordWeight
    )
VALUES('2021-3-10', '67.6');

-- INSERT INTO wa_data
--     (
--     recordDate, recordWeight
--     )
-- VALUES('2021-3-10', '67.6');