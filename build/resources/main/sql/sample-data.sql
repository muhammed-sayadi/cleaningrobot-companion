INSERT INTO
  User(firstName, lastName, email, password, phone)
    VALUE ("Muhammed", "Alsayadi", "muhammed@gmail.com", "123", 0503600270);

INSERT INTO
  Robot (model, nickname, userId, purchaseDate, batteryLevel, waterStatus, dustLevel)
  VALUE("Arrow", "arrow", 1, "15 April 2013", 45, "Clean", 12);

INSERT INTO
  Report(robotSn, startTime, finishTime, operation)
    VALUEs (1, "13:30", "15:24", "Vaccuming");

INSERT INTO
  Report(robotSn, startTime, finishTime, operation)
VALUEs (1, "8:20", "10:15", "Cleaning");

INSERT INTO
  Task(robotSn, dueDate, startingTime, operation)
  VALUE (1, "25 April 2016", "1:20", "Cleaning");

INSERT INTO
  Task(robotSn, dueDate, startingTime, operation)
  VALUE (1, "26 April 2016", "6:20", "Vacuuming");