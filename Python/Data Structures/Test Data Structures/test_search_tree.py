import unittest
import sys
import time
import random
sys.path.insert(
    0, 'C:\\Users\\Secret\\Downloads\\Nova pasta (2)\\py\\Algorithms\\Data_Structures\\Python3\\data_structures')
from binary_search_tree import search_tree


class testSearchTree(unittest.TestCase):

    def setUp(self):
        self.tree = search_tree()
        self.startTime = time.time()

    def tearDown(self):
        del self.tree
        t = time.time() - self.startTime
        print('{}: {}s'.format(self.id(), t))

    def insertNodes(self):
        self.tree.insert(13, 13)
        self.tree.insert(6, 6)
        self.tree.insert(35, 35)
        self.tree.insert(1, 1)
        self.tree.insert(11, 11)
        self.tree.insert(84, 84)
        self.tree.insert(89, 89)
        self.tree.insert(41, 41)
        self.tree.insert(39, 39)
        self.tree.insert(65, 65)
        self.tree.insert(46, 46)
        self.tree.insert(76, 76)
        self.tree.insert(75, 75)
        self.tree.insert(90, 90)
        self.tree.insert(86, 86)
        self.tree.insert(4, 4)
        self.tree.insert(5, 5)
        self.tree.insert(7, 7)
        self.tree.insert(8, 8)
        self.tree.insert(12, 12)
        self.tree.insert(-10, -10)
        self.tree.insert(-6, -6)
        self.tree.insert(97, 97)

    def testInsertNode(self):
        self.insertNodes()
        # testing issertions
        self.assertEqual(13, self.tree.root.value)
        self.assertEqual(6, self.tree.root.left.value)
        self.assertEqual(1, self.tree.root.left.left.value)
        self.assertEqual(-10, self.tree.root.left.left.left.value)
        self.assertEqual(-6, self.tree.root.left.left.left.right.value)
        self.assertEqual(4, self.tree.root.left.left.right.value)
        self.assertEqual(5, self.tree.root.left.left.right.right.value)
        self.assertEqual(11, self.tree.root.left.right.value)
        self.assertEqual(12, self.tree.root.left.right.right.value)
        self.assertEqual(7, self.tree.root.left.right.left.value)
        self.assertEqual(8, self.tree.root.left.right.left.right.value)
        self.assertEqual(35, self.tree.root.right.value)
        self.assertEqual(84, self.tree.root.right.right.value)
        self.assertEqual(41, self.tree.root.right.right.left.value)
        self.assertEqual(39, self.tree.root.right.right.left.left.value)
        self.assertEqual(65, self.tree.root.right.right.left.right.value)
        self.assertEqual(46, self.tree.root.right.right.left.right.left.value)
        self.assertEqual(
            75, self.tree.root.right.right.left.right.right.left.value)
        self.assertEqual(76, self.tree.root.right.right.left.right.right.value)
        self.assertEqual(89, self.tree.root.right.right.right.value)
        self.assertEqual(86, self.tree.root.right.right.right.left.value)
        self.assertEqual(90, self.tree.root.right.right.right.right.value)
        # testing error
        with self.assertRaises(KeyError):
            self.tree.insert(None)

    def testRemove(self):
        self.insertNodes()
        # remove leaf nodes
        self.assertTrue(self.tree.root.left.left.right.right.value == 5)
        self.tree.remove(5)
        self.assertTrue(self.tree.root.left.left.right.right == None)

        self.assertTrue(self.tree.root.left.right.left.right.value == 8)
        self.tree.remove(8)
        self.assertTrue(self.tree.root.left.right.left.right == None)

        self.assertTrue(self.tree.root.right.right.left.left.value == 39)
        self.tree.remove(39)
        self.assertTrue(self.tree.root.right.right.left.left == None)

        self.assertTrue(
            self.tree.root.right.right.left.right.right.left.value == 75)
        self.tree.remove(75)
        self.assertTrue(
            self.tree.root.right.right.left.right.right.left == None)
        # remove nodes with one child
        self.assertTrue(self.tree.root.left.left.left.value == -10)
        self.assertTrue(self.tree.root.left.left.left.right.value == -6)
        self.tree.remove(-10)
        self.assertTrue(self.tree.root.left.left.left.value == -6)
        self.assertTrue(self.tree.root.left.left.left.right == None)

        self.assertTrue(self.tree.root.right.right.left.value == 41)
        self.assertTrue(self.tree.root.right.right.left.right.value == 65)
        self.tree.remove(41)
        self.assertTrue(self.tree.root.right.right.left.value == 65)
        self.assertTrue(self.tree.root.right.right.left.right.value == 76)

        self.assertTrue(self.tree.root.right.right.right.right.value == 90)
        self.assertTrue(
            self.tree.root.right.right.right.right.right.value == 97)
        self.tree.remove(90)
        self.assertTrue(
            self.tree.root.right.right.right.right.value == 97)
        self.assertTrue(
            self.tree.root.right.right.right.right.right == None)

        # remove node with two childs
        self.assertTrue(self.tree.root.left.right.value == 11)
        self.assertTrue(self.tree.root.left.right.left.value == 7)
        self.assertTrue(self.tree.root.left.right.right.value == 12)
        self.tree.remove(11)

        self.assertTrue(self.tree.root.left.right.value == 12)
        self.assertTrue(self.tree.root.left.right.left.value == 7)
        self.assertTrue(self.tree.root.left.right.right == None)
        self.assertTrue(self.tree.root.left.value == 6)
        self.assertTrue(self.tree.root.left.right.value == 12)
        self.assertTrue(self.tree.root.left.left.value == 1)
        self.tree.remove(6)
        self.assertTrue(self.tree.root.left.value == 7)
        self.assertTrue(self.tree.root.left.right.value == 12)
        self.assertTrue(self.tree.root.left.left.value == 1)

        self.assertTrue(self.tree.root.right.right.value == 84)
        self.assertTrue(self.tree.root.right.right.left.value == 65)
        self.assertTrue(self.tree.root.right.right.right.value == 89)
        self.tree.remove(84)
        self.assertTrue(self.tree.root.right.right.value == 86)
        self.assertTrue(self.tree.root.right.right.left.value == 65)
        self.assertTrue(self.tree.root.right.right.right.value == 89)

        # test invalid keys
        with self.assertRaises(KeyError):
            self.tree.remove(None)

    def testSearch(self):
        self.insertNodes()
        self.assertEqual(self.tree.search(35).value, 35)
        self.assertEqual(self.tree.search(11).value, 11)
        self.assertEqual(self.tree.search(-10).value, -10)
        self.assertEqual(self.tree.search(1).value, 1)
        self.assertEqual(self.tree.search(13).value, 13)
        self.assertEqual(self.tree.search(65).value, 65)
        self.assertEqual(self.tree.search(65).value, 65)
        self.assertEqual(self.tree.search(90).value, 90)
        self.assertEqual(self.tree.search(75).value, 75)
        self.assertEqual(self.tree.search(None), None)
        self.assertEqual(self.tree.search(152342), None)
        self.assertEqual(self.tree.search(-1234), None)

    def testInOrder(self):
        self.insertNodes()

        array = [-10, -6, 1, 4, 5, 6, 7, 8, 11, 12, 13,
                 35, 39, 41, 46, 65, 75, 76, 84, 86, 89, 90, 97]
        self.assertEqual(self.tree.inorder(), array)

    def testAlphabeticInOrder(self):
        self.tree.insert('Arthur')
        self.tree.insert('Gabriel')
        self.tree.insert('Andre')
        self.tree.insert('Thiago')
        self.tree.insert('12341')
        self.tree.insert('Allysson')
        self.tree.insert('Victor Lucas')
        self.tree.insert('TK')
        self.tree.insert('Igor Joaquim')
        self.tree.insert('Igor Pedro')
        self.tree.insert('Keveen Douglas')
        self.tree.insert('Agregado')
        self.tree.insert('Jonathan')
        self.tree.insert('Davi')
        self.tree.insert('Sophia')
        self.tree.insert('Sofia')
        self.tree.insert('sofia')
        self.tree.insert('arthur')
        self.tree.insert('Gabi')
        self.tree.insert('#@$!%@!#1')

        array = ['#@$!%@!#1', '12341', 'Agregado', 'Allysson', 'Andre', 'Arthur',   'Davi', 'Gabi', 'Gabriel',
                 'Igor Joaquim', 'Igor Pedro', 'Jonathan', 'Keveen Douglas', 'Sofia', 'Sophia', 'TK', 'Thiago', 'Victor Lucas', 'arthur', 'sofia']
        with self.assertRaises(KeyError):
            self.tree.insert(None)
        self.assertEqual(self.tree.inorder(), array)

    def testInsertSpeed(self):
        randomlist = random.sample(range(-2000000, 2000000), 1000000)
        s = time.time()
        for i in randomlist:
            self.tree.insert(i)
        print('Time to insert two million elements: {}s'.format(time.time() - s))

    def testRemoveSpeed(self):
        randomlist = random.sample(range(-2000000, 2000000), 1000000)
        for i in randomlist:
            self.tree.insert(i)
        s = time.time()
        for i in random.shuffle(randomlist):
            self.tree.remove(i)
        print('Time to remove two million elements: {}s'.format(time.time() - s))

    # TODO testcase for posorder search
    def testPosOrder(self):
        pass

    # TODO testcase for alphabetic posorder
    def testAlphabeticPosOrder(self):
        pass

    # TODO testcase for preorder search
    def testPreOrder(self):
        pass

    # TODO testcase for alphabetic preorder
    def testAlphabeticPreOrder(self):
        pass

    # TODO testcase for find min
    def testFindMin(self):
        pass
    # TODO testcase for find min

    def testFindMax(Self):
        pass

    # TODO testcase for test beadthfirst search on iterator
    def testIterator(self):
        pass

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(testSearchTree)
    unittest.TextTestRunner(verbosity=0).run(suite)
    unittest.main()
