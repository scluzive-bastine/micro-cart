CREATE TABLE IF NOT EXISTS client (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    bio VARCHAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Must be a separate statement
INSERT INTO client (id, name, email, bio, created_at, updated_at)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John Doe',
       'john.doe@example.com',
       'Coffee-fueled product manager.',
       CURRENT_TIMESTAMP,
       CURRENT_TIMESTAMP
    WHERE NOT EXISTS (
    SELECT 1 FROM client WHERE id = '123e4567-e89b-12d3-a456-426614174000'
);
