import unittest
import sys
import time
sys.path.insert(
    0, 'C:\\Users\\Secret\\Downloads\\Nova pasta (2)\\py\\Algorithms\\Data_Structures\\Python3\\data_structures')
from linked_list import linked_list


class testLinkedList(unittest.TestCase):

    def setUp(self):
        self.dlk = linked_list()

    def tearDown(self):
        del self.dlk

    def testInsertStartNode(self):
        s = time.time()
        for i in range(1000000):
            self.dlk.insert_start(i)
        print('Time to insert one million elements: {}s'.format(time.time() - s))

        self.dlk.insert_start(10)
        self.assertEqual(self.dlk.start.value, 10)

        self.dlk.insert_start(15)
        self.assertEqual(self.dlk.start.value, 15)

        self.dlk.insert_start(30)
        self.assertEqual(self.dlk.start.value, 30)

        self.dlk.insert_start(-12415)
        self.assertEqual(self.dlk.start.value, -12415)

        self.dlk.insert_start(1234567)
        self.assertEqual(self.dlk.start.value, 1234567)

        self.dlk.insert_start(15.12412412)
        self.assertEqual(self.dlk.start.value, 15.12412412)

        self.dlk.insert_start(123 * 123)
        self.assertEqual(self.dlk.start.value, 123 * 123)

        self.dlk.insert_start(999 * 9999)
        self.assertEqual(self.dlk.start.value, 999 * 9999)

        self.dlk.insert_start('asdasd')
        self.assertEqual(self.dlk.start.value, 'asdasd')

        self.dlk.insert_start(None)
        self.assertEqual(self.dlk.start.value, None)

    def testInsertEndNode(self):

        self.dlk.insert_end(-12415)
        self.assertEqual(self.dlk.end.value, -12415)

        pass


if __name__ == '__main__':
    unittest.main()
