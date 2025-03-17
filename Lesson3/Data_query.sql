use QLSV_ADD_DATA;

-- Hiển thị danh sách tất cả các học viên
select * 
FROM student;

-- Hiển thị danh sách các học viên đang theo học
select *
FROM student
where Status = true;

-- Hiển thị danh sách các môn học có thời gian học < 10
select *
from subject
where Credit < 10;

-- Hiển thị danh sách các học viên lớp A1
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';