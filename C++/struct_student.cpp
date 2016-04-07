#include <iostream>
#include <ctime>

using namespace std;
struct Student
{
	char name[20]; 
	char surname[20];
	int marks[3];
};

Student* setData(int number);
void averMarksPrint(int marks[], int size);
void printStudentMarks(Student*A, int number);

void main()
{
	int n;
	
	cout << "Enter number of students: " << endl;
	cin >> n;

	Student *A=new Student[n];
	A = setData(n);
	printStudentMarks(A, n);
	system("pause");
}

Student* setData(int number)
{
	Student *A = new Student[number];
	for (int i = 0; i < number; i++)
	{
		cout << "Enter name: " << endl;
		cin >> A[i].name;
		cout << "Enter surname: " << endl;
		cin >> A[i].surname;
		for (int j = 0; j<3; j++)
		{
			cout << "Enter mark: "<< endl;
			cin >> A[i].marks[j];
		}
	}
	return A;
}

void averMarksPrint(int marks[])
{
	int sum = 0, size = 3;
	for (int i = 0; i < size; i++)
		sum += marks[i];

	cout << (sum / size) << endl;

}

void printStudentMarks(Student*A, int number)
{
	for (int i = 0; i < number; i++)
	{
	cout << A[i].surname << " - ";
	averMarksPrint(A[i].marks);
}


}