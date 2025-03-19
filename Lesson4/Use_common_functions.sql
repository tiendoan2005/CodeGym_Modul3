use qlsv_add_data;

-- Hiển thị số lượng sinh viên ở từng nơi;
select address, count(studentid) as 'Số lượng sinh viên'
From Student
group by address;

-- Tính điểm trung bình các môn của mỗi học viên;
select s.studentName,s.studentID, avg(mark) as 'Điểm trung bình'
from student s
join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName;

-- Hiển thị những bạn học viên có điểm trung bình các môn học lớn hơn 15;
select s.studentName,s.studentID, avg(mark) as 'Điểm trung bình'
from student s
join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(mark) > 15 ; 

-- Hiển thị thông tin học viên có điểm trung bình lớn nhất ;
select s.studentName,s.studentID, avg(mark) as 'Điểm trung bình'
from student s
join mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(mark) >= all(select avg(mark)
						From mark
                        group by mark.studentID);