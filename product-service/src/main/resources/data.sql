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
    ('cd74bec6-0b53-481f-8ea5-1b2ecb4a6e99', 'Minimalist Desk', 'A sleek wooden desk for any workspace.', 'minimalist-desk', 129.99, 'https://example.com/img/desk.jpg', now(), now()),
    ('d2adf77f-d3a1-4e25-bb95-bfacd51e2360', 'Ergonomic Chair', 'Comfortable chair with lumbar support.', 'ergonomic-chair', 199.50, 'https://example.com/img/chair.jpg', now(), now()),
    ('e7e6e71f-eefb-4d86-a209-9f6aa36d3854', 'LED Monitor 27"', 'High resolution 27-inch display.', 'led-monitor-27', 249.99, 'https://example.com/img/monitor.jpg', now(), now()),
    ('3d9bb4f0-87ea-4df6-8390-8df83fc1539c', 'Wireless Keyboard', 'Low-profile, mechanical wireless keyboard.', 'wireless-keyboard', 89.99, 'https://example.com/img/keyboard.jpg', now(), now()),
    ('1222c872-fc2b-4fa5-bcb6-36c354b93aa9', 'Gaming Mouse', 'Ergonomic gaming mouse with RGB.', 'gaming-mouse', 59.00, 'https://example.com/img/mouse.jpg', now(), now()),
    ('dd4206f2-3485-4bb6-a7e4-3dc5e2e930d0', 'Standing Desk Converter', 'Turn any desk into a standing desk.', 'standing-desk-converter', 159.99, 'https://example.com/img/converter.jpg', now(), now()),
    ('6d36ab0c-8862-4ff7-99de-b87d678d70b7', 'Webcam 1080p', 'Crystal-clear HD webcam.', 'webcam-1080p', 49.95, 'https://example.com/img/webcam.jpg', now(), now()),
    ('349fe1ee-f519-4b79-8c2f-87c7e5973c60', 'USB-C Dock', 'Expand your laptop with multiple ports.', 'usb-c-dock', 79.99, 'https://example.com/img/dock.jpg', now(), now()),
    ('9f15617a-4b7d-4ea6-bbd4-769f114e0edb', 'Noise Cancelling Headphones', 'Premium ANC headphones.', 'noise-cancelling-headphones', 299.99, 'https://example.com/img/headphones.jpg', now(), now()),
    ('6ebf1c27-706c-47ae-8e2f-95f3c650f399', 'Desk Organizer Set', 'Minimal desk organizer bundle.', 'desk-organizer-set', 35.00, 'https://example.com/img/organizer.jpg', now(), now()),
    ('f1aaf5d1-ec7e-4463-87d0-f6f4bba6e25b', 'Smart LED Lamp', 'Touch-control LED desk lamp.', 'smart-led-lamp', 45.49, 'https://example.com/img/lamp.jpg', now(), now()),
    ('ce6ce9b3-8d62-4dc9-94e3-e09b05f69b8e', 'Office Footrest', 'Under-desk ergonomic footrest.', 'office-footrest', 24.99, 'https://example.com/img/footrest.jpg', now(), now()),
    ('12fd2656-f344-4f9d-9b38-d8a0056716c4', 'Laptop Stand', 'Aluminum stand for better airflow.', 'laptop-stand', 39.99, 'https://example.com/img/stand.jpg', now(), now()),
    ('93c7a6d1-cd8a-41b3-bb7f-9d899a09efbd', 'Cable Management Kit', 'Tidy up your workspace.', 'cable-management-kit', 19.99, 'https://example.com/img/cable-kit.jpg', now(), now()),
    ('debb8232-ff95-4d88-9a9b-cc3fc45b927a', 'Productivity Timer', 'Pomodoro-style timer.', 'productivity-timer', 12.00, 'https://example.com/img/timer.jpg', now(), now());

