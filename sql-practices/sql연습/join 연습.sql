-- inner join

SELECT 
    a.emp_no, a.first_name, b.title
FROM
    employees a,
    titles b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'엔지니어(engineer)만 출력하게요.
select a.emp_no, a.first_name, a.gender, b.title
  from employees a, titles b
 where a.emp_no = b.emp_no        -- join 조건(n-1)
   and b.to_date = '9999-01-01'   -- row 선택 조건1
   and a.gender = 'f'  			  -- row 선택 조건2
   and b.title = 'engineer';      -- row 선택 조건3


--
-- ANSI/ISO SQL1999 JOIN 표준문법
--
-- 1)	natural join
-- 두 테이블에 이름이 같은 공통 컬럼이 있으면 조인 조건을 명시하지 않아도 암묵적으로 조인이 됨
select a.emp_no, a.first_name, b.title
  from employees a natural join titles b
 where b.to_date = '9999-01-01';  -- row 선택 조건
		
-- 2) join ~ using
-- natural join 문제점
select count(*)
  from salaries a natural join titles b
 where a.to_date = '9999-01-01'
   and b.to_date = '9999-01-01';

select count(*)
  from salaries a join titles b using (emp_no) 
 where a.to_date = '9999-01-01'
   and b.to_date = '9999-01-01';

-- 3) join ~ on
SELECT 
    b.title, AVG(a.salary)
FROM
    salaries a
        JOIN
    titles b ON a.emp_no = b.emp_no
WHERE
    a.to_date = '9999-01-01'
    and b.to_date = '9999-01-01'
group by b.title
order by avg(a.salary) desc;  

-- 실습문제 1: 현재 회사 상황을 반영한 직원별 근무부서를 사번, 직원 전체이름 근무부서 형태로 출력해보세요.
SELECT 
    a.emp_no, a.first_name, b.dept_name
FROM
    employees a,
    departments b,
    dept_emp c
WHERE
    a.emp_no = c.emp_no
        AND b.dept_no = c.dept_no
        AND c.to_date = '9999-01-01';
    
-- 실습문제 2: 현재 회사에서 지급되고 잇는 급여체계를 반영한 결과를 출력하세요. 사번, 전체이름, 연봉 이런 형태로
select a.emp_no, a.first_name, b.salary
from employees a, salaries b
where  a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
order by b.salary desc;

-- 실습문제 3: 현재 직책별로 평균 연봉과 인원수를 구하되 직책별로 인원이 100명 이상인 직책만 출력하세요.
SELECT 
    a.title, AVG(b.salary), COUNT(*)
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title
HAVING COUNT(*) >= '100'
ORDER BY AVG(b.salary) DESC;

-- 실습문제 4:현재 부서별로 현재 직책이 Engineer인 직원들의 대해서만 평균 급여를 구하세요.
SELECT 
    AVG(c.salary), a.dept_name, b.title
FROM
    departments a,
    titles b,
    salaries c,
    dept_emp d
WHERE
    a.dept_no = d.dept_no
        AND d.emp_no = c.emp_no
        AND c.emp_no = b.emp_no
        AND d.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
        AND b.title = 'Engineer'
GROUP BY a.dept_name;


select d.dept_name, avg(salary)
from dept_emp a, salaries b, titles c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and d.dept_no = a.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and c.title = 'Engineer'
group by d.dept_name;

