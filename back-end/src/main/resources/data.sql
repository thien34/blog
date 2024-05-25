-- Tạo dữ liệu mẫu cho bảng tag
INSERT INTO tag (data_change_created_by, data_change_created_time, data_change_last_modified_by, data_change_last_modified_time, deleted, name)
VALUES
    ('user1', '2024-05-25 10:00:00', 'user2', '2024-05-25 11:00:00', false, 'Technology'),
    ('user3', '2024-05-24 09:30:00', 'user4', '2024-05-24 12:00:00', false, 'Science'),
    ('user2', '2024-05-23 08:20:00', NULL, NULL, false, 'Health'),
    ('user5', '2024-05-22 07:15:00', 'user3', '2024-05-22 08:30:00', false, 'Education'),
    ('user1', '2024-05-21 06:10:00', NULL, NULL, true, 'Business'),
    ('user4', '2024-05-20 05:05:00', 'user1', '2024-05-20 06:00:00', false, 'Entertainment');

-- Tạo dữ liệu mẫu cho bảng blog_post
INSERT INTO blog_post (
    allow_comments,
    body,
    body_overview,
    deleted,
    end_date_utc,
    include_in_sitemap,
    meta_description,
    meta_keywords,
    meta_title,
    start_date_utc,
    title,
    data_change_created_by,
    data_change_created_time,
    data_change_last_modified_by,
    data_change_last_modified_time
)
VALUES
    (
        true,
        'This is the full body of the first blog post.',
        'Overview of the first blog post.',
        false,
        '2024-06-30 23:59:59',
        true,
        'A detailed description of the first blog post.',
        'blog, post, first',
        'First Blog Post',
        '2024-05-25 10:00:00',
        'First Post',
        'user1',
        '2024-05-25 10:00:00',
        'user2',
        '2024-05-25 11:00:00'
    ),
    (
        false,
        'This is the full body of the second blog post.',
        'Overview of the second blog post.',
        false,
        '2024-07-15 23:59:59',
        true,
        'A detailed description of the second blog post.',
        'blog, post, second',
        'Second Blog Post',
        '2024-05-24 09:30:00',
        'Second Post',
        'user3',
        '2024-05-24 09:30:00',
        'user4',
        '2024-05-24 12:00:00'
    ),
    (
        true,
        'This is the full body of the third blog post.',
        'Overview of the third blog post.',
        true,
        '2024-08-01 23:59:59',
        false,
        'A detailed description of the third blog post.',
        'blog, post, third',
        'Third Blog Post',
        '2024-05-23 08:20:00',
        'Third Post',
        'user2',
        '2024-05-23 08:20:00',
        NULL,
        NULL
    ),
    (
        true,
        'This is the full body of the fourth blog post.',
        'Overview of the fourth blog post.',
        false,
        '2024-09-01 23:59:59',
        true,
        'A detailed description of the fourth blog post.',
        'blog, post, fourth',
        'Fourth Blog Post',
        '2024-05-22 07:15:00',
        'Fourth Post',
        'user5',
        '2024-05-22 07:15:00',
        'user3',
        '2024-05-22 08:30:00'
    ),
    (
        false,
        'This is the full body of the fifth blog post.',
        'Overview of the fifth blog post.',
        true,
        '2024-10-01 23:59:59',
        false,
        'A detailed description of the fifth blog post.',
        'blog, post, fifth',
        'Fifth Blog Post',
        '2024-05-21 06:10:00',
        'Fifth Post',
        'user1',
        '2024-05-21 06:10:00',
        NULL,
        NULL
    );

-- Tạo dữ liệu mẫu cho bảng blog_post_tag_mapping
INSERT INTO blog_post_tag_mapping (
    data_change_created_by,
    data_change_created_time,
    data_change_last_modified_by,
    data_change_last_modified_time,
    deleted,
    blog_post_id,
    tag_id
)
VALUES
    (
        'user1',
        '2024-05-25 10:15:00',
        'user2',
        '2024-05-25 11:15:00',
        false,
        1,  -- ID của blog_post (First Post)
        2   -- ID của tag (Technology)
    ),
    (
        'user3',
        '2024-05-24 09:45:00',
        'user4',
        '2024-05-24 12:15:00',
        false,
        2,  -- ID của blog_post (Second Post)
        2   -- ID của tag (Science)
    ),
    (
        'user2',
        '2024-05-23 08:30:00',
        NULL,
        NULL,
        false,
        3,  -- ID của blog_post (Third Post)
        3   -- ID của tag (Health)
    ),
    (
        'user5',
        '2024-05-22 07:25:00',
        'user3',
        '2024-05-22 08:45:00',
        false,
        4,  -- ID của blog_post (Fourth Post)
        4   -- ID của tag (Education)
    ),
    (
        'user1',
        '2024-05-21 06:20:00',
        NULL,
        NULL,
        true,
        5,  -- ID của blog_post (Fifth Post)
        5   -- ID của tag (Business)
    ),
    (
        'user4',
        '2024-05-20 05:10:00',
        'user1',
        '2024-05-20 06:10:00',
        false,
        1,  -- ID của blog_post (First Post)
        6   -- ID của tag (Entertainment)
    );
