-- ---------------- --
-- Association Id --
-- ---------------- --
-- Actually, inserting associations by this way will unsync the sequence with the actual id.
-- So, we need to restart the sequence.
ALTER SEQUENCE association_association_id_seq RESTART WITH 7;