def get_input():
    while True:
      try:
        line = input()
        if line == '':
          raise SyntaxError 
        else:
          yield line
      except EOFError, SyntaxError:
        break

if __name__ == '__main__':
    a = list(get_input())
    print(a)
