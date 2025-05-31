CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    slug VARCHAR(255) UNIQUE,
    price NUMERIC(10, 2) NOT NULL,
    image_url TEXT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

INSERT INTO product (id, title, description, slug, price, image_url, created_at, updated_at)
VALUES
    (RANDOM_UUID(), 'Minimalist Desk', 'A sleek wooden desk for any workspace.', 'minimalist-desk', 129.99, 'https://example.com/img/desk.jpg', now(), now()),
    (RANDOM_UUID(), 'Ergonomic Chair', 'Comfortable chair with lumbar support.', 'ergonomic-chair', 199.50, 'https://example.com/img/chair.jpg', now(), now()),
    (RANDOM_UUID(), 'LED Monitor 27"', 'High resolution 27-inch display.', 'led-monitor-27', 249.99, 'https://example.com/img/monitor.jpg', now(), now()),
    (RANDOM_UUID(), 'Wireless Keyboard', 'Low-profile, mechanical wireless keyboard.', 'wireless-keyboard', 89.99, 'https://example.com/img/keyboard.jpg', now(), now()),
    (RANDOM_UUID(), 'Gaming Mouse', 'Ergonomic gaming mouse with RGB.', 'gaming-mouse', 59.00, 'https://example.com/img/mouse.jpg', now(), now()),
    (RANDOM_UUID(), 'Standing Desk Converter', 'Turn any desk into a standing desk.', 'standing-desk-converter', 159.99, 'https://example.com/img/converter.jpg', now(), now()),
    (RANDOM_UUID(), 'Webcam 1080p', 'Crystal-clear HD webcam.', 'webcam-1080p', 49.95, 'https://example.com/img/webcam.jpg', now(), now()),
    (RANDOM_UUID(), 'USB-C Dock', 'Expand your laptop with multiple ports.', 'usb-c-dock', 79.99, 'https://example.com/img/dock.jpg', now(), now()),
    (RANDOM_UUID(), 'Noise Cancelling Headphones', 'Premium ANC headphones.', 'noise-cancelling-headphones', 299.99, 'https://example.com/img/headphones.jpg', now(), now()),
    (RANDOM_UUID(), 'Desk Organizer Set', 'Minimal desk organizer bundle.', 'desk-organizer-set', 35.00, 'https://example.com/img/organizer.jpg', now(), now()),
    (RANDOM_UUID(), 'Smart LED Lamp', 'Touch-control LED desk lamp.', 'smart-led-lamp', 45.49, 'https://example.com/img/lamp.jpg', now(), now()),
    (RANDOM_UUID(), 'Office Footrest', 'Under-desk ergonomic footrest.', 'office-footrest', 24.99, 'https://example.com/img/footrest.jpg', now(), now()),
    (RANDOM_UUID(), 'Laptop Stand', 'Aluminum stand for better airflow.', 'laptop-stand', 39.99, 'https://example.com/img/stand.jpg', now(), now()),
    (RANDOM_UUID(), 'Cable Management Kit', 'Tidy up your workspace.', 'cable-management-kit', 19.99, 'https://example.com/img/cable-kit.jpg', now(), now()),
    (RANDOM_UUID(), 'Productivity Timer', 'Pomodoro-style timer.', 'productivity-timer', 12.00, 'https://example.com/img/timer.jpg', now(), now());

