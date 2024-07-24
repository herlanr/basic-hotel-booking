CREATE TABLE booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    checkIn DATE NOT NULL,
    checkOut DATE NOT NULL,
    userId BIGINT NOT NULL,
    roomId BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES user(id),
    FOREIGN KEY (roomId) REFERENCES room(id)
);