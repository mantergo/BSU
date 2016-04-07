
#include <fstream>
#include <iostream>
#include <cstdlib>
using namespace std;
struct Student
{
	char surname[20];
	int marks[3];
};

void main()
{
	ifstream in("students.txt");
	Student st[100];
	int count = 0;
	while (in >> st[count].surname)
	{
		in >> st[count].surname; 
		for (int i = 0; i < 3; i++)
			in >> st[count].marks[i];
		count++;
	}
	in.close();

	fstream bout("Student.bin", ios::out | ios::binary);
	bout.write((char*)st, count*sizeof(Student));
		bout.close();

		fstream bin("Student.bin", ios::in | ios::binary);
		Student* newStudent = new Student[count];
		int i = 0;
		while (!bin.eof())
		{
			bin.read((char*)&newStudent[i], sizeof(Student));
			i++;
		}
		for (int j = 0; j < i; j++)
		{
			cout << newStudent[j].surname << " ";
			for (int k = 0; k < 3; k++)
				cout << newStudent[count].marks[k] << " " << endl;;

		}

     	char student[20];
		cout << "Enter student: ";
		cin >> student;
			bool isExist = false;
		for (int j = 0; j < i; j++)
		{
			if (!strcmp(newStudent[j].surname, student))
			{
				isExist = true;
				break;
			}
		}
		if (isExist)
			cout << "Student exist.";
		else
			cout << "Student not exist.";

		system("pause");

}

