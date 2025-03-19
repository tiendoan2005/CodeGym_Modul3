use qlsv_add_data;

-- Hiển thị tất cả các thông tin môn học có credit lớn nhất ;
select *
from subject
where Credit = (select max(Credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất;
select sub.*
from subject sub
join mark on sub.SubID = mark.SubID
where mark = (select max(mark) from mark);	

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần;
select s.*, avg(mark) as 'Điểm trung bình'
from student s
join mark m on s.StudentID = m.StudentID
Group by StudentID
order by StudentID Desc;
