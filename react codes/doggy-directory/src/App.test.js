import { render, screen } from '@testing-library/react';
import App from './App';
import mockFetch from './mocks/mockFetch';

// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });

//for checking if the screen and its contents are rendered correctly
test('renders the landing page', async () => {
  render(<App />);

  expect(screen.getByRole("heading")).toHaveTextContent(/Doggy Directory/);
  expect(screen.getByRole("combobox")).toHaveDisplayValue("Select a breed");
  expect(await screen.findByRole("option", {name: "husky"})).toBeInTheDocument();
  expect(screen.getByRole("button", {name: "Search"})).toBeDisabled();
  expect(screen.getByRole("presentation")).toBeInTheDocument();
});

beforeEach(() => {
  jest.spyOn(window, "fetch").mockImplementation(mockFetch);
})

afterEach(() => {
  jest.restoreAllMocks();
})
