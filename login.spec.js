const { test, expect } = require('@playwright/test');

test('should login with valid credentials', async ({ page }) => {
  await page.goto('https://example.com/login');

  await page.fill('#email', 'test@example.com');
  await page.fill('#password', '123456');
  await page.click('button[type="submit"]');

  await expect(page).toHaveURL(/.*dashboard/);
});
