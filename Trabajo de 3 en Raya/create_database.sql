
CREATE TABLE IF NOT EXISTS GameResults (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    player1 TEXT NOT NULL,
    player2 TEXT NOT NULL,
    winner TEXT,
    score TEXT,
    status TEXT
);
